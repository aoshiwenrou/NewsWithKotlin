package com.jcking.jhttp

import okhttp3.Interceptor
import javax.net.ssl.SSLSocketFactory


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:03
 */
object HttpSettings{
    var rootUrl : String = ""
    var showLog : Boolean = true
    var sslSocketFactory : SSLSocketFactory? = null
    var interceptors : List<Interceptor> = arrayListOf()
}
