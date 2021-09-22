package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Comment(
    @PrimaryKey
    val commentId: Int?,
    val comment: String?,
    val exercise: Int?,
    @ColumnInfo(name = "comments")  val comments: String?

): Parcelable{

}