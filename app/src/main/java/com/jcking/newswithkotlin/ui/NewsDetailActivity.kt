package com.jcking.newswithkotlin.ui

import android.app.Activity
import android.os.Bundle

import com.jcking.newswithkotlin.R
import com.jcking.newswithkotlin.bean.News
import com.jcking.newswithkotlin.http.resp.PageResp
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        btn.text = intent.getParcelableExtra<PageResp<News>>("resp").toString()
    }
}
