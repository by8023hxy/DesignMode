package com.baiyu.designpattern.responsibilitychain.handler

import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: ResponsibilityHandler
 * @Description: 抽象的需求变更处理类 Handler，维护一个 nextHandler ，为当前处理者的下一个处理者的引用；
 *               声明了抽象方法 handlerRequest
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 10:37 上午
 */
abstract class ResponsibilityHandler {

    var handler: ResponsibilityHandler? = null

    fun setNextHandler(nextHandler: ResponsibilityHandler?) {
        this.handler = nextHandler
    }

    abstract fun handlerRequest(demandRequest: DemandRequest): String
}