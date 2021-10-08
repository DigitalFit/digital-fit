package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "comment")
@Parcelize
data class CommentDb(
    @PrimaryKey
    val commentId: Int?,
    val comment: String?,
    //ForeignKey
    val exerciseId: Int?
): Parcelable