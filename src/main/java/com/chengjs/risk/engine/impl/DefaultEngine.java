package com.chengjs.risk.engine.impl;

import com.chengjs.risk.engine.IValidateEngine;
import com.chengjs.risk.engine.ValidateCore;
import com.chengjs.risk.entity.Risk;
import com.chengjs.risk.entity.RiskResult;
import com.chengjs.risk.entity.Validator;
import com.chengjs.risk.enums.RiskTypeEnum;
import com.chengjs.risk.exception.RiskException;
import com.chengjs.risk.tools.RiskMsgUtil;
import com.chengjs.risk.tools.UUIDUtil;
import com.chengjs.risk.tools.XMLUtil;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.chengjs.risk.enums.ExceptionCodeEnum.E0001;

/**
 * DefaultEngine: 默认风险比对引擎
 * 读取properties里的风险配置,进行风险比对,产生风险结果
 *
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class DefaultEngine implements IValidateEngine{

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  private static final String NAME = "默认引擎DefaultEngine";

  public void validate(Validator validator, RiskResult result) throws RiskException, DocumentException, IOException, ScriptException {
    String id = validator.getId();//风险校验记录id
    List<Map<String, String>> o1 = validator.getO1();//风险被校验对象
    List<Map<String, String>> o2 = validator.getO2();//风险校验对象
    List<RiskTypeEnum> types = validator.getTypes();//风险处理类型
    if (null == types || 0 == types.size()) {
      throw new RiskException(E0001.code(),E0001.msg() + "，风险处理类型types为" + types);
    }
    Set<Risk> riskSet = result.getResult();
    String result_Msg = "";

    logger.info("=================>>>>>>>>引擎"  + this.getClass().getName() + "处理风险开始：");
    logger.info("风险被比对对象： " + o1);
    logger.info("风险比对对象： " + o2);
    Element ele = null;//风险条件xml元素risk
    String el_script = ""; //风险验证脚本
    String highest = result.getHighest();//产生风险的最高级别

    /*
     * 默认风险比对 默认只有o1的一行数据为有校数据,按照各参数名称对应的映射到风险脚本中，判断是否符合风险标准
     * 此处设计参数为 o1,o2,engins是为了方便扩展多种不同的风险校验，接口中IValidateEngine参数设计成Object也是可以的，后期再做考虑
      * */
    Map<String, String> paramsMap = o1.get(0);
    try {
      for (RiskTypeEnum type : types) {
        ele = XMLUtil.getFxElement(type);
        Iterator it = ele.elementIterator();

        logger.info("开始处理风险类型" + type + ":");
        while (it.hasNext()) {
          Element riskEle = (Element) it.next();
          String code = riskEle.element("code").getTextTrim();
          String desc = riskEle.element("desc").getTextTrim();
          String level = riskEle.element("level").getTextTrim();
          String script = riskEle.element("script").getTextTrim();

          boolean b = ValidateCore.booleanEval(script, paramsMap);
          if (b) {
            logger.debug("风险比对脚本:" + script +"产生风险");
            highest = highest.compareTo(level) > 0 ? highest : level;
            Risk risk = new Risk();
            risk.setId(UUIDUtil.getUUID());
            risk.setCode(code);
            risk.setDesc(desc);
            risk.setLevel(level);
            risk.setScript(script);
            risk.setType(String.valueOf(type));
            String riskMsg = RiskMsgUtil.formatRiskMsg(code,desc,level,script,type,validator);
            risk.setSituation(riskMsg);
            riskSet.add(risk);
          }
        }
        logger.info("<<<<<<<=================正常结束处理风险类型" + type + ":");

      }

      result.setId(id);
      result.setNum(riskSet.size());
      result.setHighest(highest);
      result_Msg += String.format("风险%s级,%d条", highest, riskSet.size());

      logger.info("引擎"  + this.getClass().getName() + "处理风险结束。 " + result_Msg);
    } catch (DocumentException e) {
      result_Msg += NAME + ",文件异常。";
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      result_Msg += NAME +  ",IO异常。";
      e.printStackTrace();
      throw e;
    } catch (ScriptException e) {
      result_Msg +=  NAME + ",Script解析异常。 参数为：" + paramsMap + " 。";
      e.printStackTrace();
      throw e;
    } finally {
      result.setMsg(result_Msg);
    }

  }


}
