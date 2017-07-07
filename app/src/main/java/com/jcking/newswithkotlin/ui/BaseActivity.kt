package com.jcking.newswithkotlin.ui

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import com.jcking.jhttp.JHttp
import com.jcking.newswithkotlin.http.RespParser
import com.jcking.newswithkotlin.http.resp.Resp
import retrofit2.Call

fun Context.toast(msg: String){Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()}

fun <T: Parcelable> Activity.http(call: Call<Resp<T>>, success: (T?) -> Unit){
    JHttp.asyn(call, { RespParser.parseResp(this, it, success)}, {RespParser.handleError(this, it)})
}

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
