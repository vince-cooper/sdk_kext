package com.wangwh.sdk.kext

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * 作者: wenhui.w
 * 日期: 2024-10-22 19:31
 * 描述: 库主要类
 */
@SuppressLint("StaticFieldLeak")
object KExt {
    /**
     * 该变量引用的是 Application Context, 没有内存泄漏问题
     */
    lateinit var appCtx: Context

    fun initialize(ctx: Context) {
        if (::appCtx.isInitialized) {
            throw IllegalStateException("KExt is already initialized")
        }
        this.appCtx = if (ctx is Application) ctx else ctx.applicationContext
    }
}