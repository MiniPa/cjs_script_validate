package com.chengjs.risk;

import com.chengjs.risk.engine.IValidateEngine;
import com.chengjs.risk.engine.ValidateHandle;
import com.chengjs.risk.engine.impl.DefaultEngine;
import com.chengjs.risk.entity.RiskResult;
import com.chengjs.risk.entity.Validator;
import com.chengjs.risk.exception.RiskException;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RiskManager: 风险管理类 风险管理的入口
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class RiskManager {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private static final ValidateHandle VALIDATE_HANDLE = ValidateHandle.getInstance();

  /**
   * 多条风险比对对象集合比对
   * @param validators 风险被比对对象集合
   * @return
   */
  public static List<RiskResult> validates(List<Validator> validators) throws RiskException, DocumentException, ScriptException, IOException {
    List<RiskResult> resultList = new ArrayList<RiskResult>();
    for (Validator validator : validators) {
      resultList.add(VALIDATE_HANDLE.handle(validator));
    }
    System.out.println("风险比对结果:" + resultList);
    return resultList;
  }

  /**
   * 单个风险比对对象风险比对
   * @param validator 风险比对被比对对象
   * @return
   */
  public static RiskResult validate(Validator validator) {
    //TODO 暂时用不上 用到再做处理
    return null;
  }

}
