package com.chengjs.risk.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * RiskLevelEnum: 风险等级
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public enum RiskLevelEnum {

  /** 风险等级一 */
  FIRST("1","风险等级一"),
  SECOND("2","风险等级二"),
  THIRD("3","风险等级三");

  /** 枚举值码 */
  private final String code;
  /** 枚举描述 */
  private final String message;

  RiskLevelEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public String code() {
    return code;
  }

  public String message() {
    return message;
  }

  /**
   * 通过枚举值码查找枚举值。
   * @param code 查找枚举值的枚举值码。
   * @return 枚举值码对应的枚举值。
   * @throws IllegalArgumentException 如果 code 没有对应的 riskEnum 。
   */
  public static RiskLevelEnum findRisk(String code) {
    for (RiskLevelEnum risk : values()) {
      if (risk.getCode().equals(code)) {
        return risk;
      }
    }
    throw new IllegalArgumentException("ResultInfo riskEnum not legal:" + code);
  }

  /**
   * 获取全部枚举值。
   * @return 全部枚举值。
   */
  public static List<RiskLevelEnum> getAllRisk() {
    List<RiskLevelEnum> list = new ArrayList<RiskLevelEnum>();
    for (RiskLevelEnum risk : values()) {
      list.add(risk);
    }
    return list;
  }

  /**
   * 获取全部枚举值码。
   * @return 全部枚举值码。
   */
  public static List<String> getAllRiskCode() {
    List<String> list = new ArrayList<String>();
    for (RiskLevelEnum risk : values()) {
      list.add(risk.code());
    }
    return list;
  }

}
