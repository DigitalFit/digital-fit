package com.example.digitalfit.modelApi

import androidx.recyclerview.widget.DiffUtil

data class ResultInfo(
    val category: Category,
    val comments: List<Comment>,
    val creation_date: String,
    val description: String,
    val equipment: List<Equipment>,
    val id: Int,
    val images: List<Image>,
    val language: Language,
    val license: License,
    val license_author: String,
    val muscles: List<Muscle>,
    val muscles_secondary: List<MusclesSecondary>,
    val name: String,
    val uuid: String,
    val variations: List<Int>
) {
    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<ResultInfo> =
            object : DiffUtil.ItemCallback<ResultInfo>() {
                override fun areItemsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}