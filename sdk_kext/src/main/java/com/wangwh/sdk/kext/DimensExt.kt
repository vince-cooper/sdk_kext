package com.wangwh.sdk.kext

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import androidx.annotation.DimenRes

/**
 * 作者: wenhui.w
 * 日期: 2024-10-22 19:11
 * 描述:
 */

fun Context.dimens(@DimenRes res: Int): Float = resources.getDimension(res)
fun Context.dimensPS(@DimenRes res: Int): Int = resources.getDimensionPixelSize(res)
fun Context.dimensPO(@DimenRes res: Int): Int = resources.getDimensionPixelOffset(res)

fun View.dimens(@DimenRes res: Int): Float = ctx.dimens(res)
fun View.dimensPS(@DimenRes res: Int): Int = ctx.dimensPS(res)
fun View.dimensPO(@DimenRes res: Int): Int = ctx.dimensPO(res)

fun Fragment.dimens(@DimenRes res: Int): Float? = ctx?.dimens(res)
fun Fragment.dimensPS(@DimenRes res: Int): Int? = ctx?.dimensPS(res)
fun Fragment.dimensPO(@DimenRes res: Int): Int? = ctx?.dimensPO(res)

fun Activity.dimens(@DimenRes res: Int): Float = ctx.dimens(res)
fun Activity.dimensPS(@DimenRes res: Int): Int = ctx.dimensPS(res)
fun Activity.dimensPO(@DimenRes res: Int): Int = ctx.dimensPO(res)

// dimen to px
val Int.px: Int get() = KExt.app.dimensPS(this)

// dp to px
fun dp2Px(ctx: Context, dp: Float): Int {
    val density = ctx.resources.displayMetrics.density
    return (dp * density + 0.5f).toInt()
}

val Float.dp2px: Int get() = dp2Px(KExt.app, this)
val Int.dp2px: Int get() = this.toFloat().dp2px
