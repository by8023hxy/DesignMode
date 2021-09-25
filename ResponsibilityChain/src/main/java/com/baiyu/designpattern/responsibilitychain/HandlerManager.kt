package com.baiyu.designpattern.responsibilitychain

import android.util.Log
import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest
import com.baiyu.designpattern.responsibilitychain.handler.ResponsibilityHandler
import java.util.*

/**
 * @ProjectName: DesignPatternDemo
 * @ClassName: HandlerManager
 * @Description: 责任处理管理类
 * @Author: BaiYu
 * @Email: baiyu0502@foxmail.com
 * @CreateDate: 2021/9/25 11:12 上午
 */
open class HandlerManager internal constructor(builder: Builder) {

    private var onCompleteListener: ((String) -> Unit)? = null

    fun setCompleteListener(onCompleteListener: ((String) -> Unit)?) {
        this.onCompleteListener = onCompleteListener
    }

    @get:JvmName("interceptors")
    val interceptors: List<ResponsibilityHandler> =
        Collections.unmodifiableList(builder.interceptors)

    open fun newBuilder(): Builder = Builder(this)

    class Builder constructor() {
        internal val interceptors: MutableList<ResponsibilityHandler> = mutableListOf()

        internal constructor(handlerManager: HandlerManager) : this() {
            this.interceptors += handlerManager.interceptors
        }

        fun addInterceptor(interceptor: ResponsibilityHandler) = apply {
            interceptors += interceptor
        }

        fun build(): HandlerManager = HandlerManager(this)
    }

    /**
     * 第一种情况所有责任链上的人，都需要对这个变更进行相应的处理
     */
    fun handler(demandRequest: DemandRequest) {
        Log.d("Responsibility", "客户提出：${demandRequest.demandName}")
        interceptors.forEach {
            val str = it.handlerRequest(demandRequest)
            onCompleteListener?.let { onComplete -> onComplete(str) }
        }
    }

    /**
     * 第二种情况，责任链上，有人发现客户提出的变更，无法完成，中止向下传递
     * 以技术不具备可行性，中止此次传递处理
     */
    fun handler2(demandRequest: DemandRequest) {
        Log.d("Responsibility", "客户提出：${demandRequest.demandName}")
        run outside@{
            interceptors.forEachIndexed { index, responsibilityHandler ->
                val str = responsibilityHandler.handlerRequest(demandRequest)
                onCompleteListener?.let { onComplete -> onComplete(str) }
                if (index < interceptors.size) {
                    responsibilityHandler.setNextHandler(interceptors[index + 1])
                    if (str.contains("不具备可行性")) {
                        return@outside
                    }
                }
            }
        }
    }
}