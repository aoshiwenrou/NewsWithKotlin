package com.jcking.newswithkotlin.http.resp


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:40
 */
data class PageResp<T>(val totalPage: Int, val result: T)