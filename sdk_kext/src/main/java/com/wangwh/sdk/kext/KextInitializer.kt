package com.wangwh.sdk.kext

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/**
 * 作者: wenhui.w
 * 日期: 2024-10-25 10:29
 * 描述: App Startup初始化库
 */
class KextInitializer : Initializer<KExt> {
    /**
     * Initializer.create() 函数的调用时机是在 Application.onCreate() 之前，
     * 由 App Startup 的 InitializationProvider 负责调用。
     *
     * @param context Application ctx
     * @return
     */
    override fun create(context: Context): KExt {
        Log.d("KextInitializer", "call create")
        KExt.initialize(context)
        return KExt
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}