package com.chengjs.risk.entity;

import com.chengjs.risk.engine.IValidateEngine;
import com.chengjs.risk.enums.RiskTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Validator: 风险比对对象
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class Validator {

  /**
   * 风险比对对象id
   */
  private String id;

  /**
   * 被比对对象 是一个多条记录Record的List集合
   */
  List<Map<String,String>> o1 = null;

  /**
   * 比对对象 是一个多条记录Record的List集合
   */
  List<Map<String,String>> o2 = null;

  /**
   * 额外的比对引擎,在默认引擎比对结束后,依次进行特殊引擎的比对
   */
  List<IValidateEngine> engines = null;

  /**
   * 风险默认风险引擎中,风险类型
   */
  List<RiskTypeEnum> types = null;

  public Validator() { }

  public Validator(String id,
                   List<Map<String, String>> o1,
                   List<Map<String, String>> o2,
                   List<IValidateEngine> engines,
                   List<RiskTypeEnum> types) throws Exception {
    if (null == o1) {
      throw new Exception("初始化Validator失败,参数o1不能为空");
    }
    this.id = id;
    this.o1 = o1;
    this.o2 = o2;
    this.engines = engines;
    if (null == types || 0 == types.size()) {
      this.types = new ArrayList<RiskTypeEnum>();
      this.types.add(RiskTypeEnum.SS);
    } else {
      this.types = types;
    }
  }

  public String getId() { return id; }

  public void setId(String id) { this.id = id; }

  public List<Map<String, String>> getO1() {
    return o1;
  }

  public void setO1(List<Map<String, String>> o1) {
    this.o1 = o1;
  }

  public List<Map<String, String>> getO2() {
    return o2;
  }

  public void setO2(List<Map<String, String>> o2) {
    this.o2 = o2;
  }

  public List<IValidateEngine> getEngines() {
    return engines;
  }

  public void setEngines(List<IValidateEngine> engines) {
    this.engines = engines;
  }

  public List<RiskTypeEnum> getTypes() { return types; }

  public void setTypes(List<RiskTypeEnum> types) { this.types = types; }

  @Override
  public String toString() {
    return "Validator{" +
        "id='" + id + '\'' +
        ", o1=" + o1 +
        ", o2=" + o2 +
        ", engines=" + engines +
        ", types=" + types +
        '}';
  }
}
