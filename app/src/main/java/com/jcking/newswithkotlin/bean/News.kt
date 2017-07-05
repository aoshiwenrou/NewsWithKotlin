package com.jcking.newswithkotlin.bean

import android.os.Parcel
import android.os.Parcelable
import com.jcking.newswithkotlin.http.resp.PageResp
import java.lang.reflect.ParameterizedType


/**
 *
 * @author Jcking
 * @time 2017/7/4 11:51
 */
data class News(var id: String = "",
                var content: String = "",
                var createTime: Long = 0,
                var topTime: Long = 0,
                var updateTime: Long = 0,
                var image: String = "",
                var title: String = "",
                var summary: String = "",
                var userName: String = "",
                var detailsUrl: String = "")
    : Parcelable {

    constructor(source: Parcel) : this() {
        this.id = source.readString()
        this.content = source.readString()
        this.createTime = source.readLong()
        this.topTime = source.readLong()
        this.updateTime = source.readLong()
        this.image = source.readString()
        this.title = source.readString()
        this.summary = source.readString()
        this.userName = source.readString()
        this.detailsUrl = source.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.id)
        dest.writeString(this.content)
        dest.writeLong(this.createTime)
        dest.writeLong(this.topTime)
        dest.writeLong(this.updateTime)
        dest.writeString(this.image)
        dest.writeString(this.title)
        dest.writeString(this.summary)
        dest.writeString(this.userName)
        dest.writeString(this.detailsUrl)
    }

    companion object {

        @JvmField val CREATOR: Parcelable.Creator<News> = object : Parcelable.Creator<News> {
            override fun createFromParcel(source: Parcel): News {
                return News(source)
            }

            override fun newArray(size: Int): Array<News?> {
                return arrayOfNulls(size)
            }
        }
    }
}
