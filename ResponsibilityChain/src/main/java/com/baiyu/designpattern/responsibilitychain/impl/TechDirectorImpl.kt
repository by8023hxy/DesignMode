package com.baiyu.designpattern.responsibilitychain.impl

import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest
import com.baiyu.designpattern.responsibilitychain.handler.ResponsibilityHandler

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: TeamManagerImpl
 * @Description: 技术主管责任实现类
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 10:46 上午
 */
class TechDirectorImpl : ResponsibilityHandler() {

    override fun handlerRequest(demandRequest: DemandRequest): String {
        if (demandRequest.feasibility){
            return "技术主管：技术这块没什么问题，具体看开发周期，研发能否完成"
        }
        return "技术主管：这个变更，不具备可行性，不建议修改"
    }
}