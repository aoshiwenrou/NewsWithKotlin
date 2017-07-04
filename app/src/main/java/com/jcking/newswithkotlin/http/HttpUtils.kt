package com.jcking.newswithkotlin.http

import com.jcking.jutils.AppUtils
import com.jcking.newswithkotlin.App
import com.jcking.newswithkotlin.http.HttpUtils.postMapUtility

fun Map<String,String>.withUtility() = plus(postMapUtility())

/**
 *
 * @author Jcking
 * @time 2017/7/4 17:07
 */
object HttpUtils{

    fun postMapUtility(): Map<String, String> = mapOf(
            "source" to "app",
            "channel" to "3",
            "lang" to "zh_CN",
            "version" to AppUtils.getVersionName(App.get().applicationContext)
    )
}