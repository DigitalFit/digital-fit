package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "language")
@Parcelize
data class LanguageDb(
    @PrimaryKey
    val languageId: Int?,
    val full_name: String?,
    val short_name: String?
): Parcelable{

}