package com.baiyu.designpattern.responsibilitychain.impl

import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest
import com.baiyu.designpattern.responsibilitychain.handler.ResponsibilityHandler

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: DeveloperImpl
 * @Description: 开发人员责任实现类
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 10:49 上午
 */
class DeveloperImpl : ResponsibilityHandler() {

    override fun handlerRequest(demandRequest: DemandRequest): String {
        if (demandRequest.developmentCycle > 10) {
            return "研发：开发周期没问题，可以改....."
        }
        return "研发：开发周期太紧，干不完！！！"
    }
}