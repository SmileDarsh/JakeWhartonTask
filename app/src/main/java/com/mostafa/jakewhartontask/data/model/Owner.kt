package com.mostafa.jakewhartontask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
@Entity(tableName = "owners")
class Owner {
    @PrimaryKey
    @ColumnInfo(name = "fkUserId")
    var userId: Int = 0
    @ColumnInfo(name = "ownerId")
    var id: Int = 0
    @SerializedName("login")
    @Expose
    @ColumnInfo(name = "ownerName")
    var name: String? = null
    @SerializedName("html_url")
    @Expose
    @ColumnInfo(name = "ownerHtmlUrl")
    var htmlUrl: String? = null
    @SerializedName("avatar_url")
    @Expose
    var image: String? = null
}