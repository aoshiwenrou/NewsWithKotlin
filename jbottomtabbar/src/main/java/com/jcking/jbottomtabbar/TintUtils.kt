package com.jcking.jbottomtabbar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat


/**
 *
 * @author Jcking
 * @time 2017/7/7 16:28
 */
object TintUtil {
    //===================设置ImageView的Tint==========================

    //第一种：API15之后可以直接在xml文件中设置tint，兼容4.0.3 ~ 6.0

    //第二种：传入ColorId

    /**
     * @param context
     * *
     * @param drawable 图片转换成的Drawable
     * *
     * @param colorId  颜色资源的id
     * *
     * @return
     */
    fun setTint(context: Context, drawable: Drawable, colorId: Int): Drawable {
        //return getTintDrawable(drawable, context.getResources().getColor(colorId));
        return getTintDrawable(drawable, ContextCompat.getColor(context, colorId))
    }

    //第三种：传入Color或者“#FFFFFF”

    /**
     * @param drawable 同上
     * *
     * @param color    颜色，eg:Color.paserColor("#FF0000") || Color.Black || Color.rgb(0,0,0)....
     * *
     * @return
     */
    fun setTint(drawable: Drawable, @ColorInt color: Int): Drawable {
        return getStateDrawable(drawable, ColorStateList.valueOf(color))
    }

    /**
     * @param drawable 同上
     * *
     * @param colorStr eg:#FF0000
     * *
     * @return
     */
    fun setTint(drawable: Drawable, colorStr: String): Drawable {
        return getStateDrawable(drawable, ColorStateList.valueOf(Color.parseColor(colorStr)))
    }

    //===================设置ImageView的Selector.Tint==========================

    //第一种：推荐使用，兼容6.0及其以下版本，传入ColorId、Color或者“#FFFFFF”

    /**
     * @param context
     * *
     * @param drawable      同上
     * *
     * @param colorId       样式同上，这是未选择的
     * *
     * @param colorSelectId 样式同上，这是选择的
     * *
     * @return
     */
    fun setStateListTintColorId(context: Context, drawable: Drawable, colorId: Int, colorSelectId: Int): Drawable {
        return setStateListTintColor(drawable, ContextCompat.getColor(context, colorSelectId), ContextCompat.getColor(context, colorId))
    }

    /**
     * @param drawable    同上
     * *
     * @param color       样式同上，这是未选择的
     * *
     * @param colorSelect 样式同上，这是选择的
     * *
     * @return
     */
    fun setStateListTintColor(drawable: Drawable, @ColorInt color: Int, @ColorInt colorSelect: Int): Drawable {
        val colors = intArrayOf(colorSelect, colorSelect, color)
        val states = arrayOf(
                intArrayOf(android.R.attr.state_pressed),
                intArrayOf(android.R.attr.state_selected),
                intArrayOf()
        )
        val stateListDrawable = getStateListDrawable(drawable, states)
        val colorList = ColorStateList(states, colors)
        return getStateDrawable(stateListDrawable, colorList)
    }

    fun setStateListTintDrawable(drawableSelect: Drawable, drawableUnSelect: Drawable): Drawable {
        val drawable = StateListDrawable()
        drawable.addState(intArrayOf(android.R.attr.state_pressed),
                drawableSelect)
        drawable.addState(intArrayOf(android.R.attr.state_selected),
                drawableSelect)
        drawable.addState(intArrayOf(),
                drawableUnSelect)
        return drawable
    }

    /**
     * @param drawable       同上
     * *
     * @param colorStr       样式同上，这是未选择的
     * *
     * @param colorSelectStr 样式同上，这是选择的
     * *
     * @return
     */
    fun setStateListTintColorStr(drawable: Drawable, colorStr: String, colorSelectStr: String): Drawable {
        return setStateListTintColor(drawable, Color.parseColor(colorSelectStr), Color.parseColor(colorStr))
    }

    //第二种：只兼容6.0以下的版本，只做介绍，不推荐使用，传入ColorId、Color或者“#FFFFFF”

    /**
     * @param context
     * *
     * @param drawable
     * *
     * @param colorId       样式同上，这是未选择的
     * *
     * @param colorSelectId 样式同上，这是选择的
     * *
     * @return
     */
    fun setStateListTint_low_6_0_ColorId(context: Context, drawable: Drawable, colorId: Int, colorSelectId: Int): Drawable {
        val colors = intArrayOf(ContextCompat.getColor(context, colorSelectId), ContextCompat.getColor(context, colorId))
        val states = arrayOfNulls<IntArray>(2)
        states[0] = intArrayOf(android.R.attr.state_pressed)
        states[1] = intArrayOf()
        val colorList = ColorStateList(states, colors)
        return getStateDrawable(drawable, colorList)
    }

    /**
     * @param drawable
     * *
     * @param color       样式同上，这是未选择的
     * *
     * @param colorSelect 样式同上，这是选择的
     * *
     * @return
     */
    fun setStateListTint_low_6_0_Color(drawable: Drawable, color: Int, colorSelect: Int): Drawable {
        val colors = intArrayOf(colorSelect, color)
        val states = arrayOfNulls<IntArray>(2)
        states[0] = intArrayOf(android.R.attr.state_pressed)
        states[1] = intArrayOf()
        val colorList = ColorStateList(states, colors)
        return getStateDrawable(drawable, colorList)
    }

    /**
     * @param drawable
     * *
     * @param colorStr       样式同上，这是未选择的
     * *
     * @param colorSelectStr 样式同上，这是选择的
     * *
     * @return
     */
    fun setStateListTint_low_6_0_ColorStr(drawable: Drawable, colorStr: String, colorSelectStr: String): Drawable {
        val colors = intArrayOf(Color.parseColor(colorSelectStr), Color.parseColor(colorStr))
        val states = arrayOfNulls<IntArray>(2)
        states[0] = intArrayOf(android.R.attr.state_pressed)
        states[1] = intArrayOf()
        val colorList = ColorStateList(states, colors)
        return getStateDrawable(drawable, colorList)
    }

    //第三种：只兼容6.0以下的版本，只做介绍，不推荐使用，传入一个selector的颜色选择器(value文件夹下新建一个color文件夹，在color文件夹下创建这个selector)
    //    <selector xmlns:android="http://schemas.android.com/apk/res/android">
    //        <item android:color="#FF4081" android:state_pressed="true" />
    //        <item android:color="#3F51B5" />
    //    </selector>

    /**
     * @param context
     * *
     * @param drawable
     * *
     * @param id       eg:R.color.abc,文件位置在value下的color中
     * *
     * @return
     */
    fun setStateListTint_low_6_0(context: Context, drawable: Drawable, id: Int): Drawable {
        return getStateDrawable(drawable, context.resources.getColorStateList(id))
    }

    //===================内部处理方法，不对外开放==================================

    fun getTintDrawable(drawable: Drawable, color: Int): Drawable {
        val state = drawable.constantState
        val wrappenDrawable = DrawableCompat.wrap(if (state == null) drawable else state.newDrawable()).mutate()
        wrappenDrawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        DrawableCompat.setTint(wrappenDrawable, color)
        return wrappenDrawable
    }

    fun getStateDrawable(drawable: Drawable, colorStateList: ColorStateList): Drawable {
        val state = drawable.constantState
        val wrappenDrawable = DrawableCompat.wrap(if (state == null) drawable else state.newDrawable()).mutate()
        DrawableCompat.setTintList(wrappenDrawable, colorStateList)
        return wrappenDrawable
    }

    fun getStateListDrawable(drawable: Drawable, states: Array<IntArray>): StateListDrawable {
        val stateListDrawable = StateListDrawable()
        for (state in states) {
            stateListDrawable.addState(state, drawable)
        }
        return stateListDrawable
    }
}