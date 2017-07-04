package com.jcking.jhttp.interceptor

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class ToStringConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        if (String::class.java == type) {
            return Converter<ResponseBody, Any> { responseBody -> responseBody.string() }
        }
        return null
    }
}