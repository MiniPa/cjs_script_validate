package com.chengjs.risk.engine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * ValidateCoreTest: 测试通过
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class ValidateCoreTest {

  @Test
  public void booleanEval() throws Exception {
    Map<String, String> params = new HashMap<String, String>();
    params.put("mj","100");
    params.put("dz","100");
    params.put("fw","100");
    List<String> els = new ArrayList<String>();
    els.add("(mj>20 and dz>100) or fw>20");//true
    els.add("(mj>101 and dz>100) or fw>20");//true
    els.add("mj==100 and dz>100");//false
    els.add("mj!=100 and dz>100");//false

    for (String el : els) {
      ValidateCore.booleanEval(el, params);
    }

  }

  /**
   * 中文替换也是可行的
   * @throws Exception
   */
  @Test
  public void booleanEvalChinese() throws Exception {
    Map<String, String> params = new HashMap<String, String>();
    params.put("面积","100");
    params.put("地址","100");
    params.put("房屋","100");
    List<String> els = new ArrayList<String>();
    els.add("(面积>20 and 地址>100) or 房屋>20");//true
    els.add("(面积>101 and 地址>100) or 房屋>20");//true
    els.add("面积==100 and 地址>100");//false
    els.add("面积!=100 and 地址>100");//false

    for (String el : els) {
      ValidateCore.booleanEval(el, params);
    }

  }
}