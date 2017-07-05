package com.jcking.newswithkotlin.http.req

import com.jcking.jhttp.JHttpClient
import com.jcking.newswithkotlin.bean.News
import com.jcking.newswithkotlin.http.resp.PageResp
import com.jcking.newswithkotlin.http.resp.Resp
import com.jcking.newswithkotlin.http.withUtility
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 *
 * @author Jcking
 * @time 2017/7/4 10:33
 */

object NewsReq {
    val api: NewsApi by lazy { JHttpClient.createApi(NewsApi::class.java) }

    fun getNewsList(currentPageNo: Int) = api.getNewsList(mapOf("currentPageNo" to currentPageNo.toString()).withUtility())
}

interface NewsApi {
    @GET("news/getnewslistpageJsonByApp")
    fun getNewsList(@QueryMap params: Map<String, String>): Call<Resp<PageResp<News>>>
}