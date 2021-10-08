package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "equipment")
@Parcelize
data class EquipmentDb(
    @PrimaryKey
    val equipmentId: Int?,
    val name: String?,
): Parcelable