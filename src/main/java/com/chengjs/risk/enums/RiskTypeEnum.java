package com.chengjs.risk.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * RiskTypeEnum:
 * 这里的风险类型，同时也是任务类型
 * author: Chengjs, version:1.0.0, 2017-08-06
 */
public enum RiskTypeEnum {

  /** 风险等级一 */
  SS("SS","审税"),
  CJ("CJ","采集"),
  SB("SB","申报");

  /** 枚举值码 */
  private final String code;
  /** 枚举描述 */
  private final String message;

  RiskTypeEnum(String code, String message) {
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
  public static RiskTypeEnum findRiskType(String code) {
    for (RiskTypeEnum risk : values()) {
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
  public static List<RiskTypeEnum> getAllRisk() {
    List<RiskTypeEnum> list = new ArrayList<RiskTypeEnum>();
    for (RiskTypeEnum risk : values()) {
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
    for (RiskTypeEnum risk : values()) {
      list.add(risk.code());
    }
    return list;
  }

}
