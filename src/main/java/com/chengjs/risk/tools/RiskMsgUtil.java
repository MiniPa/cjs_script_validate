package com.chengjs.risk.tools;

import com.chengjs.risk.entity.Validator;
import com.chengjs.risk.enums.RiskTypeEnum;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * RiskMsgUtil: 风险引擎产生的风险描述
 * 输入结果范例如下： 组织并替换相应的英文字段
 * "风险Q0001等级3，不符合条件"面积>20 and 年龄>34"，风险描述。 现实际情况为"面积：19，年龄18 ...""
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class RiskMsgUtil {

  public static final String RISK_MSG = "实际情况为\"%s\"";

  /**
   * @param code
   * @param desc
   * @param level
   * @param script
   * @param type
   * @param validator
   * @return
   */
  public static String formatRiskMsg(String code, String desc,
                                     String level, String script, RiskTypeEnum type, Validator validator) {
    String msg = RISK_MSG;
    RiskTypeEnum riskType = RiskTypeEnum.findRiskType(String.valueOf(type));
    List<Map<String, String>> o1 = validator.getO1();//风险被校验对象
    List<Map<String, String>> o2 = validator.getO2();//风险校验对象
    String situation = "";
    situation += getMsg(o1);
    situation += getMsg(o2);
    msg = String.format(msg, situation);
    msg = msg.toLowerCase();
    /* 替换msg中额英文字段为中文字段名 */
    Properties prop = PropertiesUtil.getProp();
    Iterator<Map.Entry<Object, Object>> it = prop.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Object, Object> entry = it.next();
      String key = (String) entry.getKey();
      String value = (String) entry.getValue();
      msg = msg.replaceAll(key, value);
    }
    return msg;
  }

  private static String getMsg(List<Map<String, String>> o) {
    String situation = "";
    if (null == o) {
      return situation;
    }
    situation += "[";
    for (Map<String, String> stringStringMap : o) {
      situation += "{ ";
      if (0 < stringStringMap.size()) {
        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
          situation += entry.getKey() + "：" + entry.getValue() + "，";
        }
        situation = situation.substring(0, situation.length() - 1);
      }
      situation += " }，";
    }
    if (0 <= o.size()) {
      situation = situation.substring(0, situation.length() - 1);
    }
    situation += "]";
    return situation;
  }

}
