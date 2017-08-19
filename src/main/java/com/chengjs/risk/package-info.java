/**
 * package-info: 房地产内部监控模块 风险审批模块核心代码
 * author: Chengjs, version:1.0.0, 2017-08-04
 *
 * 使用方式:
 *  1.Validator 实现比对对象接口, VFactory.getManager(validator) 获取 VMananger对象
 *    vManager.validate() 返回VResult风险结果对象
 *  2.IValidatorEngine 实现特殊的比对器,注入给validator, 则validate()在执行完正常比对逻辑后,会继续执行特殊比对逻辑
 *    最后返回VResult风险结果对象
 */
package com.chengjs.risk;