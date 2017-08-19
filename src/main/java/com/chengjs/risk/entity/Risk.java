package com.chengjs.risk.entity;

/**
 * Risk: 风险
 * author: Chengjs, version:1.0.0, 2017-08-04
 */
public class Risk {

  /**
   * 1.风险id uuid, 每产生一条风险会 新增一个uuid
   */
  private String id;

  /**
   * 2.风险类型 @see com.chengjs.risk.enums.RiskTypeEnum
   */
  private String type;

  /**
   * 3.风险等级 @see com.chengjs.risk.enums.RiskLevelEnum
   */
  private String level;

  /**
   * 4.风险代码 配置文件中用户配置的
   */
  private String code;

  /**
   * 5.风险描述 配置文件中用户配置的
   */
  private String desc;

  /**
   * 6.风险条件脚本
   */
  private String script;

  /**
   * 7.风险实际情况描述如："房屋面积"xxx",不满足"xxxxdesc"情况"
   */
  private String situation;

  public Risk() { }

  public Risk(String id, String type, String level, String code, String desc, String script, String situation) {
    this.id = id;
    this.type = type;
    this.level = level;
    this.code = code;
    this.desc = desc;
    this.script = script;
    this.situation = situation;
  }

  public String getScript() { return script; }

  public void setScript(String script) { this.script = script; }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getSituation() {
    return situation;
  }

  public void setSituation(String situation) {
    this.situation = situation;
  }

  @Override
  public String toString() {
    return "Risk{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", level='" + level + '\'' +
        ", code='" + code + '\'' +
        ", desc='" + desc + '\'' +
        ", script='" + script + '\'' +
        ", situation='" + situation + '\'' +
        '}';
  }
}
