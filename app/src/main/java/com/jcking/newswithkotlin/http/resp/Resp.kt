package com.jcking.newswithkotlin.http.resp

import android.os.Parcel
import android.os.Parcelable
import java.lang.reflect.ParameterizedType


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:36
 */
data class Resp<T: Parcelable>(var retCode: Int = 0,
                               var retMsg: String = "",
                               var data: T? = null)
    : Parcelable {

    val EMPTY = "empty"

    constructor(source: Parcel) : this() {
        retCode = source.readInt()
        retMsg = source.readString()
        val className = source.readString()
        data = if(className == EMPTY) null else source.readParcelable(Class.forName(className).getClassLoader())
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
        dest.writeInt(this.retCode)
        dest.writeString(this.retMsg)
        dest.writeString(if(this.data==null) EMPTY else this.data!!::class.java.name)
        dest.writeParcelable(this.data, flags)
    }

    companion object {

        @JvmField val CREATOR: Parcelable.Creator<Resp<Parcelable>> = object : Parcelable.Creator<Resp<Parcelable>> {
            override fun createFromParcel(source: Parcel): Resp<Parcelable> {
                return Resp<Parcelable>(source)
            }

            override fun newArray(size: Int): Array<Resp<Parcelable>?> {
                return arrayOfNulls(size)
            }
        }
    }
}