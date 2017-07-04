package com.jcking.jhttp

import com.jcking.jhttp.interceptor.LogInterceptorJava
import com.jcking.jhttp.interceptor.ToStringConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * @author Jcking
 * @time 2017/7/4 12:01
 */
object JHttpClient{

    val retrofit : Retrofit by lazy { build() }

    fun build(): Retrofit = Retrofit.Builder().baseUrl(HttpSettings.rootUrl)
            .addConverterFactory(ToStringConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkClient()).build()

    fun getOkClient(): OkHttpClient = createBuilderByInterceptors()
            .addNetworkInterceptor(LogInterceptorJava())
            .sslSocketFactory(HttpSettings.sslSocketFactory)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build()

    fun createBuilderByInterceptors(): OkHttpClient.Builder{
        val builder = OkHttpClient.Builder()
        for(interceptor in HttpSettings.interceptors)
            builder.addInterceptor(interceptor)
        return builder
    }

    fun <T> createApi(clazz: Class<T>) : T = retrofit.create(clazz)

}