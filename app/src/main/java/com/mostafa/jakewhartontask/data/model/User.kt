package com.mostafa.jakewhartontask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
@Entity(tableName = "users")
class User {
    @PrimaryKey
    @ColumnInfo(name = "userId")
    var id: Int = 0
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "userName")
    var name: String? = null
    @SerializedName("html_url")
    @Expose
    @ColumnInfo(name = "userHtmlUrl")
    var htmlUrl: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("watchers")
    @Expose
    var watchers: Int = 0
    @Ignore
    var owner: Owner = Owner()
}