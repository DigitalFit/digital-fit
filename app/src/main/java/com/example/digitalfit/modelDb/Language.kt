package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Language(
    val languageId: Int?,
    val full_name: String?,
    val short_name: String?,
    @ColumnInfo(name = "language") val language: String
): Parcelable{

}