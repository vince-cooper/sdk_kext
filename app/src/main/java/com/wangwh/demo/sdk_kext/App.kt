package com.wangwh.demo.sdk_kext

import android.app.Application
import com.wangwh.sdk.kext.KExt

/**
 * 作者: wenhui.w
 * 日期: 2024-10-23 16:19
 * 描述:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KExt.app = this
    }
}