package com.jcking.newswithkotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcking.jhttp.JHttp
import com.jcking.jutils.LogUtils
import com.jcking.newswithkotlin.R
import com.jcking.newswithkotlin.http.req.NewsReq
import kotlinx.android.synthetic.main.fragment_news_list.*


/**
 *
 * @author Jcking
 * @time 2017/7/7 16:48
 */
class NewsListFragment: Fragment(){

    var currentPageNo = 1

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initData()
    }

    private fun initData() {
        activity.http(NewsReq.getNewsList(currentPageNo)){
            btn.text = it.toString()
        }
    }
}