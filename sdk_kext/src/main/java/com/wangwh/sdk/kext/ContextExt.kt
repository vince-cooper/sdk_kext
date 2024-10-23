package com.wangwh.sdk.kext

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View

/**
 * 作者: wenhui.w
 * 日期: 2024-10-22 19:14
 * 描述:
 */

val View.ctx: Context get() = this.context
val Fragment.ctx: Context? get() = this.context
val Activity.ctx: Context get() = this
