package com.example.digitalfit.adapterAPI


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalfit.R
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.modelApi.Image
import com.example.digitalfit.modelApi.ResultInfo

class ExerciseAdapterApi(
    private val exercisesList: List<ResultInfo>,
    private val onClickListener: (exercises: ResultInfo) -> Unit
) : RecyclerView.Adapter<ExerciseAdapterApi.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExerciseItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exercisesList[position], onClickListener)
    }

    override fun getItemCount() = exercisesList.size

    class ViewHolder(
        val binding: ExerciseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            exercises: ResultInfo,
            onClickListener: (exercises: ResultInfo) -> Unit,
        ) {
            with(binding) {
                tvExercise.text = exercises.name
                cvExercise.setOnClickListener {
                    onClickListener(exercises)
                }
                //se imagem não for null, carrega primeira imagem da lista
                Glide
                    .with(itemView.context)
                    .load(exercises.images.firstOrNull()?.image)
                    .placeholder(R.drawable.noimage)
                    .into(ivExercise)
            }
        }
    }
}
