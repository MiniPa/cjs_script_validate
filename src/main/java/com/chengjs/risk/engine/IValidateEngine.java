package com.chengjs.risk.engine;

import com.chengjs.risk.entity.RiskResult;
import com.chengjs.risk.entity.Validator;
import com.chengjs.risk.exception.RiskException;
import org.dom4j.DocumentException;

import javax.script.ScriptException;
import java.io.IOException;

/**
 * IValidateEngine: 风险比对接口
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public interface IValidateEngine {

  /**
   * 引擎开始比对
   * @param validator
   * @param result
   * @return
   */
  void validate(Validator validator, RiskResult result) throws RiskException, DocumentException, IOException, ScriptException;

}
