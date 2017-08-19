package com.chengjs.risk.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * ExceptionCodeEnum: 异常代码
 * author: Chengjs, version:1.0.0, 2017-08-06
 */
public enum ExceptionCodeEnum {

  /** 风险等级一 */
  E0001("ExceptionCode0001","比对对象未提供比对类型异常");

  /** 枚举值码 */
  private final String code;
  /** 枚举描述 */
  private final String msg;

  ExceptionCodeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public String getCode() { return code; }

  public String getMsg() { return msg; }

  public String code() { return code; }

  public String msg() { return  msg; }

  /**2
   * 通过枚举值码查找枚举值。
   * @param code 查找枚举值的枚举值码。
   * @return 枚举值码对应的枚举值。
   * @throws IllegalArgumentException 如果 code 没有对应的 ExceptionCodeEnum 。
   */
  public static ExceptionCodeEnum findExceptionCode(String code) {
    for (ExceptionCodeEnum ExceptionCodeEnum : values()) {
      if (ExceptionCodeEnum.getCode().equals(code)) {
        return ExceptionCodeEnum;
      }
    }
    throw new IllegalArgumentException("ResultInfo ExceptionCodeEnum not legal:" + code);
  }

  /**
   * 获取全部枚举值。
   * @return 全部枚举值。
   */
  public static List<ExceptionCodeEnum> getAllExceptionCode() {
    List<ExceptionCodeEnum> list = new ArrayList<ExceptionCodeEnum>();
    for (ExceptionCodeEnum ExceptionCodeEnum : values()) {
      list.add(ExceptionCodeEnum);
    }
    return list;
  }

  /**
   * 获取全部枚举值码。
   * @return 全部枚举值码。
   */
  public static List<String> getAllExceptionCodeCode() {
    List<String> list = new ArrayList<String>();
    for (ExceptionCodeEnum ExceptionCodeEnum : values()) {
      list.add(ExceptionCodeEnum.code());
    }
    return list;
  }

}
