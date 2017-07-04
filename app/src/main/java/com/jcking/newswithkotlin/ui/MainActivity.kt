package com.jcking.newswithkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jcking.jhttp.JHttp
import com.jcking.jutils.LogUtils
import com.jcking.newswithkotlin.R
import com.jcking.newswithkotlin.http.req.NewsReq
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentPageNo = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            JHttp.asyn(NewsReq.getNewsList(currentPageNo), {resp -> LogUtils.e(msg = "success : $resp") }){
                LogUtils.e("fail : ${it.message}")
            }
        }
    }
}
