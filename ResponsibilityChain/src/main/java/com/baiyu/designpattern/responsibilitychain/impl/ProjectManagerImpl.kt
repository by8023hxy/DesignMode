package com.baiyu.designpattern.responsibilitychain.impl

import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest
import com.baiyu.designpattern.responsibilitychain.handler.ResponsibilityHandler

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: ProjectManagerImpl
 * @Description: 项目经理责任实现类
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 10:51 上午
 */
class ProjectManagerImpl : ResponsibilityHandler() {

    override fun handlerRequest(demandRequest: DemandRequest): String {
        if (demandRequest.developmentCost>0){
            return "项目经理：好的，好的，我们马上制定变更计划"
        }
        return "项目经理：提需求变更吧，我们内部讨论下"
    }
}