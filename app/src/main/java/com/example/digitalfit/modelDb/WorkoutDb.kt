package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "workout")
@Parcelize
data class WorkoutDb(
    @PrimaryKey(autoGenerate = true)
    val workoutId: Long,
    val name: String?,
    val description: String = ""
): Parcelable{

}