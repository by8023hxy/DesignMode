package com.baiyu.designpattern.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.baiyu.designpattern.responsibilitychain.HandlerManager
import com.baiyu.designpattern.responsibilitychain.bean.DemandRequest
import com.baiyu.designpattern.responsibilitychain.impl.DeveloperImpl
import com.baiyu.designpattern.responsibilitychain.impl.ProductManagerImpl
import com.baiyu.designpattern.responsibilitychain.impl.ProjectManagerImpl
import com.baiyu.designpattern.responsibilitychain.impl.TechDirectorImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //客户发起需求变更---项目经理---产品经理---技术主管---研发
        val demandRequest = DemandRequest(
            "我想要把画廊间距改成等间距的，有没有问题？",
            15, 1000.0
        )
        val demandRequest1 = DemandRequest(
            "我想要根据用户的手机壳开改变软件主题颜色，有没有问题？",
            15, 1000.0,false
        )
        val handlerManager = HandlerManager.Builder()
            .addInterceptor(ProjectManagerImpl())
            .addInterceptor(ProductManagerImpl())
            .addInterceptor(TechDirectorImpl())
            .addInterceptor(DeveloperImpl())
            .build()
        handlerManager.setCompleteListener {
            Log.d("Responsibility", it)
        }
//        handlerManager.handler(demandRequest)
        handlerManager.handler2(demandRequest1)

    }
}