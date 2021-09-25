package com.baiyu.designpattern.responsibilitychain.impl

import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest
import com.baiyu.designpattern.responsibilitychain.handler.ResponsibilityHandler

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: ProductManagerImpl
 * @Description: 产品经理责任实现类
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 10:50 上午
 */
class ProductManagerImpl : ResponsibilityHandler() {

    override fun handlerRequest(demandRequest: DemandRequest): String {
        return "产品经理：这需求给技术主管看看，能不能实现？"
    }
}