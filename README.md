# cjs_script_validate
用JavaScript比较器实现的风险校验核心组件

###1.结构分析 主要对象：
* IValidateEngine   风险比对接口  
* DefaultEngine     默认风险比对引擎  
* ValidateCore      比对核心类  
* RiskManager       风险管理类 风险管理的入口  

* Risk              风险对象  
* RiskResult        风险比对结果  
* Validator         风险比对对象  
* RiskException     风险比对引擎异常  

### 2.主流程：
* 1.xml 读取风险配置信息, 产生风险 Validator 对象  
* 2.RiskManager.validates(~)  &nbsp;&nbsp;&nbsp;&nbsp; RiskManager.validate(~)  调用并启用风险管理方法  
* 3.RiskManager使用外部提供的符合 IValidateEngine 接口的风险校验器 和 被校验数据 开始进行校验，若为提供校验器则使用默认DefaultEngine实现
* 4.校验产生 Risk 风险，并返回 RiskResult 

### 3.使用方式:
 *  1.Validator 实现比对对象接口, VFactory.getManager(validator) 获取 VMananger对象
 *    vManager.validate() 返回VResult风险结果对象
 *  2.IValidatorEngine 实现特殊的比对器,注入给validator, 则validate()在执行完正常比对逻辑后,会继续执行特殊比对逻辑
 *    最后返回VResult风险结果对象

