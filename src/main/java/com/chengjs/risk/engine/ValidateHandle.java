package com.chengjs.risk.engine;

import com.chengjs.risk.engine.impl.DefaultEngine;
import com.chengjs.risk.entity.RiskResult;
import com.chengjs.risk.entity.Validator;
import com.chengjs.risk.exception.RiskException;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

/**
 * ValidateHandle:
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class ValidateHandle {
  private static ValidateHandle ourInstance = new ValidateHandle();

  public static ValidateHandle getInstance() {
    return ourInstance;
  }

  private ValidateHandle() {
  }

  private static Logger logger = LoggerFactory.getLogger(ValidateHandle.class);

  /**
   * 默认风险比对引擎
   */
  private static final DefaultEngine DEFAULT_ENGINE = new DefaultEngine();

  /**
   * 先用默认引擎分析风险，在看是否带有额外引擎，有则再用额外引擎处理
   * @param validator
   * @return
   */
  public RiskResult handle(Validator validator) throws RiskException, DocumentException, ScriptException, IOException {
    RiskResult result = new RiskResult();
    DEFAULT_ENGINE.validate(validator, result);
    List<IValidateEngine> engines = validator.getEngines();
    if (null != engines) {
      for (IValidateEngine engine : engines) {
        engine.validate(validator, result);
      }
    }
    return result;
  }

}
