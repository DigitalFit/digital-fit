package com.example.digitalfit.modelApi

import androidx.recyclerview.widget.DiffUtil

data class Result(
    val category: Int,
    val creation_date: String,
    val description: String,
    val equipment: List<Int>,
    val exercise_base: Int,
    val id: Int,
    val language: Int,
    val license: Int,
    val license_author: String,
    val muscles: List<Int>,
    val muscles_secondary: List<Int>,
    val name: String,
    val status: String,
    val uuid: String,
    val variations: List<Int>,
    //image
    val image: String,
    val is_main: Boolean
)
    // {
//
//    companion object {
//        var DIFF_CALLBACK: DiffUtil.ItemCallback<Result> =
//            object : DiffUtil.ItemCallback<Result>() {
//                override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
//                    return oldItem.id == newItem.id
//                }
//
//                override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
//                    return oldItem.id == newItem.id
//                }
//            }
//    }
//}
