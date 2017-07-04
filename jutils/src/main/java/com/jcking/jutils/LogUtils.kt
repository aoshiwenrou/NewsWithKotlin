package com.jcking.jutils

import android.util.Log


/**
 *
 * @author Jcking
 * @time 2017/7/4 14:33
 */
object LogUtils {
    val TAG = "---->"
    val EMPTY_MSG = "empty msg !"
    var DEBUG = true

    fun d(tag: String = TAG, msg: String = EMPTY_MSG) {
        if (DEBUG) Log.d(tag, msg)
    }

    fun i(tag: String = TAG, msg: String = EMPTY_MSG) {
        if (DEBUG) Log.i(tag, msg)
    }

    fun e(tag: String = TAG, msg: String = EMPTY_MSG, thr: Throwable? = null) {
        if (DEBUG) Log.e(tag, msg, thr)
    }
}