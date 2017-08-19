package com.chengjs.risk.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * RiskResult: 风险比对结果
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class RiskResult {

  private static final String NUM_NORISK = "0";
  private static final String NUM_EXCEPTION = "-1";

  private static final String MSG_NORISK = "比对完成，无风险产生。";
  private static final String MSG_EXCEPTION = "比对过程产生异常，请检查配置，或联系管理员。";

  /**
   * 风险比对结果id
   */
  private String id;

  /**
   * 比对产生的风险集合
   */
  private Set<Risk> result;

  /**
   * 比对产生的风险数量 0-无风险 >0 风险条数 -1比对风险过程异常
   */
  private Integer num;

  /**
   * 比对风险集的反馈信息，风险引擎执行一次比对可能会产生多条的风险Risks，
   * 此msg为这一次执行的总体风险描述,
   */
  private String msg;

  /**
   * 此比对对象的最高等级风险,无风险为0
   */
  private String highest;

  public RiskResult() {
    this.id = id;
    this.result = new HashSet<Risk>();
    this.num = 0;
    this.msg = "无风险产生";
    this.highest = "0";
  }

  public RiskResult(String id, Set<Risk> result, Integer num, String msg, String highest) {
    this.id = id;
    this.result = result;
    this.num = num;
    this.msg = msg;
    this.highest = highest;
  }

  public String getId() { return id; }

  public void setId(String id) { this.id = id; }

  public String getHighest() { return highest; }

  public void setHighest(String highest) { this.highest = highest; }

  public Set<Risk> getResult() {
    return result;
  }

  public void setResult(Set<Risk> result) {
    this.result = result;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "RiskResult{" +
        "id='" + id + '\'' +
        ", result=" + result +
        ", num=" + num +
        ", msg='" + msg + '\'' +
        ", highest='" + highest + '\'' +
        '}';
  }
}
