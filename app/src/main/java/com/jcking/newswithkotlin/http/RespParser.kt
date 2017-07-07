package com.jcking.newswithkotlin.http

import android.content.Context
import android.os.Parcelable
import com.jcking.newswithkotlin.http.resp.Resp
import com.jcking.newswithkotlin.ui.toast


/**
 *
 * @author Jcking
 * @time 2017/7/7 17:08
 */
object RespParser{

    fun <T: Parcelable> parseResp(context: Context, resp: Resp<T>, success: (T?) -> Unit){
        if(resp.retCode == 0)
            success(resp.data)
        else
            showError(context, "${resp.retMsg} (${resp.retCode})")
    }

    fun handleError(context: Context, thr: Throwable){
        showError(context, thr.message!!)
    }

    fun showError(context: Context, msg: String) {
        context.toast(msg)
    }
}