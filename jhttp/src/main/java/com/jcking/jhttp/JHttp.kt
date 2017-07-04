package com.jcking.jhttp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 * @author Jcking
 * @time 2017/7/4 11:15
 */
class JHttp {

    companion object {
        fun <T> asyn(call: Call<T>, success: (T) -> Unit, fail: (Throwable) -> Unit) {
              call.enqueue(object : Callback<T>{
                  override fun onResponse(call: Call<T>?, response: Response<T>?) {
                      if (response != null) {
                          success(response.body() as T)
                      }
                  }

                  override fun onFailure(call: Call<T>?, t: Throwable?) {
                      if (t != null) {
                          fail(t)
                      }
                  }
              })
        }
    }
}