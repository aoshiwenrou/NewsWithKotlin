package com.jcking.newswithkotlin.http.resp

import android.os.Parcel
import android.os.Parcelable
import java.lang.reflect.ParameterizedType


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:36
 */
data class Resp<T>(val retCode: Int, val retMsg: String, val data: T)
//    : Parcelable {
//
//    constructor(source: Parcel) : this(source.readInt(), source.readString()
//            , source.readParcelable(Class<T>().classLoader))
//
////    fun classLoader() : ClassLoader {
////        val type = javaClass.genericSuperclass
////        val params = (type as ParameterizedType).actualTypeArguments
////        return (params[0] as Class<T>).classLoader
////    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeInt(this.retCode)
//        dest.writeString(this.retMsg)
//        dest.writeParcelable(this.data, flags)
//    }
//
//    companion object {
//
//        @JvmField val CREATOR: Parcelable.Creator<Resp> = object : Parcelable.Creator<Resp> {
//            override fun createFromParcel(source: Parcel): Resp {
//                return Resp(source)
//            }
//
//            override fun newArray(size: Int): Array<Resp?> {
//                return arrayOfNulls(size)
//            }
//        }
//    }
//}