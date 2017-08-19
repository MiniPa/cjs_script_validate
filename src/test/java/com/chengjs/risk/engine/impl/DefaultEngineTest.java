package com.chengjs.risk.engine.impl;

import com.chengjs.risk.entity.RiskResult;
import com.chengjs.risk.entity.Validator;
import com.chengjs.risk.enums.RiskTypeEnum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * DefaultEngineTest:
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class DefaultEngineTest {

  private static Logger logger = LoggerFactory.getLogger(DefaultEngine.class);

  @Test
  public void validate() throws Exception {
    DefaultEngine de = new DefaultEngine();
    RiskResult rr = new RiskResult();

    List<Map<String, String>> o1 = new ArrayList<Map<String, String>>();
    List<Map<String, String>> o2 = new ArrayList<Map<String, String>>();
    Map<String, String> o1mp1 = new HashMap<String, String>();
    Map<String, String> o1mp2 = new HashMap<String, String>();
    Map<String, String> o2mp1 = new HashMap<String, String>();
    Map<String, String> o2mp2 = new HashMap<String, String>();
    o1mp1.put("mj", "20"); // mj=20
    o1mp1.put("jg", "20"); // jg=20
    o1mp1.put("desc", "xxx异常kkk"); // jg=20
    o1mp1.put("rq", "100");
    o1.add(o1mp1);

    ArrayList<RiskTypeEnum> types = new ArrayList<RiskTypeEnum>();
    types.add(RiskTypeEnum.SS);

    Validator validator = new Validator();
    validator.setO1(o1);
    validator.setO2(o2);
    validator.setTypes(types);
    de.validate(validator,rr);

    logger.debug(this.getClass().getName() + ": " + String.valueOf(rr));
  }

}