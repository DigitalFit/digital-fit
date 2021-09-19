package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Equipment(
    @PrimaryKey
    val equipmentId: Int?,
    val name: String?,
    @ColumnInfo(name = "equipament") val equipment: String?
): Parcelable{

}