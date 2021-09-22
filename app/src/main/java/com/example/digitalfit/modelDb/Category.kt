package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Category(
    @PrimaryKey
    val categoryId: Int?,
    val name: String?,
    @ColumnInfo(name = "category") val category: String?
) : Parcelable{

}