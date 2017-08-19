package com.chengjs.risk.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

/**
 * ValidateCore: 比对核心类
 *  判断String 如 "(34>20 and 23<100) or 1<=20" 的逻辑真假
 *  ScriptEngine解析脚本 http://blog.csdn.net/u014792352/article/details/74644791
 *
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class ValidateCore {

  private static Logger logger = LoggerFactory.getLogger(ValidateCore.class);
  private static ScriptEngineManager manager;
  private static ScriptEngine engine;

  /**
   * @param el 需要解析的风险条件字符串
   * @param params 需要带入的字符串中的参数值 注意参数名称 和配置中保持一致
   * @return true 符合条件产生风险
   */
  public static boolean booleanEval(String el, Map<String,String> params) throws ScriptException {
    manager = new ScriptEngineManager();
    engine = manager.getEngineByName("js");
    el = el.replace("or", "||").replace("and","&&");
    for (Map.Entry<String, String> entry : params.entrySet()) {
      engine.put(entry.getKey().toLowerCase(),entry.getValue().toLowerCase());
      el = el.replaceAll(entry.getKey().toLowerCase(), entry.getValue().toLowerCase());
    }
    boolean eval = false;
    logger.debug(el + "开始校验 el script: " + el);
    Object result = engine.eval(el);
    if ("true".equals(result.toString())) {
      eval = true;
    }
    logger.debug(el + "结果类型: "+result.getClass().getName()+"，计算结果： "+result);
    return eval;
  }

}