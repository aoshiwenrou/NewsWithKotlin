package com.jcking.newswithkotlin.http.resp

import android.os.Parcel
import android.os.Parcelable
import java.lang.reflect.ParameterizedType


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:40
 */
data class PageResp<T: Parcelable>(var totalPage: Int = 0, var result: Array<T>? = null)
    : Parcelable {

    constructor(source: Parcel) : this() {
        totalPage = source.readInt()
        result = source.readArray(classLoader()) as Array<T>?
    }

    fun classLoader() : ClassLoader {
        val type = javaClass.genericSuperclass
        val params = (type as ParameterizedType).actualTypeArguments
        return (params[0] as Class<T>).classLoader
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.totalPage)
        dest.writeArray(this.result)
    }

    companion object {

        @JvmField val CREATOR: Parcelable.Creator<PageResp<Parcelable>> = object : Parcelable.Creator<PageResp<Parcelable>> {
            override fun createFromParcel(source: Parcel): PageResp<Parcelable> {
                return PageResp<Parcelable>(source)
            }

            override fun newArray(size: Int): Array<PageResp<Parcelable>?> {
                return arrayOfNulls(size)
            }
        }
    }
}