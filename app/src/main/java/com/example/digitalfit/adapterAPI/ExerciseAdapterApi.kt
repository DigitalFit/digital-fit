package com.example.digitalfit.adapterAPI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.adapter.ExerciseAdapter
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.modelApi.Result
import com.example.digitalfit.utils.ResponseApi

// class ExerciseAdapterApi(
//
//    private val onClickListener: (movie: com.example.digitalfit.modelApi.Result) -> Unit
//    ) : PagedListAdapter<Result, ExerciseAdapterApi.ViewHolder>(ResponseApi.DIFF_CALLBACK){
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val binding = ExerciseItemBinding
//            .inflate(LayoutInflater.from(parent.context), parent, false)
//        return RecyclerView.ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if(holder is ExerciseAdapter.ViewHolder) {
//            holder.bind(getItem(position), onClickListener)
//        }
//    }
//
//
//        class ViewHolder(
//            private val binding: ExerciseItemBinding
//        ) : RecyclerView.ViewHolder(binding.root)
//
//
//}
//
//            fun bind(
//                movie: com.example.digitalfit.modelApi.Result?,
//                onClickListener: (movie: com.example.digitalfit.modelApi.Result) -> Unit,
//            ) {
//                with(binding) {
//                    movie?.let {
//                        tvExercise.text = movie.title
//                        ibExercise.setOnClickListener {
//                            onClickListener(movie)
//                        }
//
//                        Glide
//                            .with(itemView.context)
//
//                           .into(ivExercise)
//                    }
//                }
//            }
//        }
//}
//
//
//
//
//
//
//}