package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "category")
@Parcelize
data class CategoryDb(
    @PrimaryKey
    val categoryId: Int?,
    val name: String?
) : Parcelable