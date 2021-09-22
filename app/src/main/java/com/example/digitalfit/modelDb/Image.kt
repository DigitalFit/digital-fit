package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Image(
    @PrimaryKey
    val imageId: Int?,
    val exercise_base: Int?,
    val image: String?,
    val is_main: Boolean?,
    val status: String?,
    val uuid: String?,
    @ColumnInfo(name = "images") val images: String
): Parcelable{

}