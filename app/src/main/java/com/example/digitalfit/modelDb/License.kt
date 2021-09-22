package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class License(
    @PrimaryKey
    val licenseId: Int?,
    val full_name: String?,
    val short_name: String?,
    val url: String,
    @ColumnInfo(name = "license") val license: String
): Parcelable{

}