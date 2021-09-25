package com.baiyu.designpattern.responsibilitychain.bean

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: LeaveRequest
 * @Description: 发起需求变更的实体类
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 10:39 上午
 */
data class DemandRequest(var demandName:String, var developmentCycle:Int,var developmentCost:Double,var feasibility:Boolean=true)
