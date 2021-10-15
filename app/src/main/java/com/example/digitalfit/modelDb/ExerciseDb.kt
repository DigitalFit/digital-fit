package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "exercise")
@Parcelize
data class ExerciseDb(
    @PrimaryKey
    val exerciseId: Int?,
    //ForeignKey
    val categoryId: Int?,
    val creation_date: String?,
    val description: String?,
    //ForeignKey
    val languageId: Int?,
    //ForeignKey
    val licenseId: Int?,
    val license_author: String?,
    val name: String?,
    val uuid: String?,
): Parcelable
{
    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<ExerciseDb> =
            object : DiffUtil.ItemCallback<ExerciseDb>() {
                override fun areItemsTheSame(oldItem: ExerciseDb, newItem: ExerciseDb): Boolean {
                    return oldItem.exerciseId == newItem.exerciseId
                }

                override fun areContentsTheSame(oldItem: ExerciseDb, newItem: ExerciseDb): Boolean {
                    return oldItem.exerciseId == newItem.exerciseId
                }
            }
    }
}