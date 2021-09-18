package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
@Parcelize
data class Exercise(
    @PrimaryKey
    val id: Int,
    @Embedded
    val category: Category,
    @Embedded
    val comments: List<Comment>,
    val creation_date: String,
    val description: String,
    @Embedded
    val equipment: List<Equipment>,
    @Embedded
    val images: List<Image>,
    @Embedded
    val language: Language,
    @Embedded
    val license: License,
    val license_author: String,
    @Embedded
    val muscles: List<Muscle>,
    @Embedded
    val muscles_secondary: List<MusclesSecondary>,
    val name: String,
    val uuid: String,
): Parcelable {
    companion object{
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Exercise> =
            object : DiffUtil.ItemCallback<Exercise>() {
                override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                    return oldItem.id == newItem.id
                }
                override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}