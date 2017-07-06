package com.jcking.jbottomtabbar

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

fun Context.inflate(@LayoutRes res: Int): View = LayoutInflater.from(this).inflate(res, null)

/**
 *
 * @author Jcking
 * @time 2017/7/5 17:05
 */
class JBottomTabBar(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr){
    init {
        orientation = HORIZONTAL
    }
}

class JBottomTab(@StringRes val name: Int, @DrawableRes val icon: Int = 0, val fragment: Fragment){

    val view: View
    val ivIcon: ImageView
    val tvName: TextView

    init {
        view = fragment.activity.inflate(R.layout.item_bottom_tab)

        ivIcon = view.findViewById(R.id.iv_bottom_tab_icon)
        ivIcon.visibility = if(icon==0) View.GONE else View.VISIBLE
        ivIcon.setImageResource(icon)

        tvName = view.findViewById(R.id.tv_bottom_tab_name)
        tvName.setText(name)
    }
}