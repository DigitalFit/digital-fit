package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "image")
@Parcelize
data class ImageDb(
    @PrimaryKey
    val imageId: Int?,
    //ForeignKey
    val exerciseId: Int?,
    val exercise_base: Int?,
    val image: String?,
    val is_main: Boolean?,
    val status: String?,
    val uuid: String?,
): Parcelable{

}