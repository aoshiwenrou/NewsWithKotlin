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

    val EMPTY = "empty"

    constructor(source: Parcel) : this() {
        totalPage = source.readInt()
        val className = source.readString()
        result = if(className == EMPTY) null else source.readParcelableArray(Class.forName(className).getClassLoader()) as Array<T>?
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
        dest.writeString(if(this.result==null) EMPTY else this.result!!::class.java.name)
        dest.writeParcelableArray(this.result, flags)
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