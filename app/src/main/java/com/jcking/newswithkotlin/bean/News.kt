package com.jcking.newswithkotlin.bean


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:51
 */
data class News(val id: String,
                val content: String,
                val createTime: Long,
                val topTime: Long,
                val updateTime: Long,
                val image: String,
                val title: String,
                val summary: String,
                val userName: String,
                val detailsUrl: String)

