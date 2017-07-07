package com.jcking.newswithkotlin.ui

import android.graphics.Color
import android.os.Bundle
import com.jcking.jbottomtabbar.JBottomTabBar
import com.jcking.newswithkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_bar.setup(supportFragmentManager)
                .setImgSize(90f, 90f)
                .setFontSize(12f)
                .setTabPadding(4f, 6f, 10f)
                .setChangeColor(Color.GREEN, Color.RED)
                .addTabItem("第一项", R.mipmap.ic_launcher, NewsListFragment::class.java)
                .addTabItem("第二项", R.mipmap.ic_launcher, NewsListFragment::class.java)
                .addTabItem("第三项", R.mipmap.ic_launcher, NewsListFragment::class.java)
                .addTabItem("第四项", R.mipmap.ic_launcher, NewsListFragment::class.java)
                .setTabBarBackgroundResource(R.mipmap.ic_launcher)
                .isShowDivider(false)
                .setOnTabChangeListener(object: JBottomTabBar.OnTabChangeListener{
                    override fun onTabChange(position: Int, name: String) {
                        toast(name)
                    }
                })
    }
}
