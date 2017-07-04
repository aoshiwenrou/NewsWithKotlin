package com.jcking.jutils

import android.content.Context
import android.content.pm.PackageManager


/**
 *
 * @author Jcking
 * @time 2017/7/4 17:13
 */
object AppUtils {

    /**
     * 获取版本命
     */
    fun getVersionName(context: Context): String =
            context.packageManager.getPackageInfo(context.packageName, 0).versionName
}