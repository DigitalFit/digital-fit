package com.example.digitalfit.adapterAPI


import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalfit.R
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.modelDb.ExerciseWithImages


class ExerciseAdapterDb(
    //private val exercisesList: List<ResultInfo>,
    private val onClickListener: (exercises: ExerciseWithImages) -> Unit,
//) : RecyclerView.Adapter<ExerciseAdapterApi.ViewHolder>() {
    private val onSharedListener: (shared: Bitmap) -> Unit
) : PagedListAdapter<ExerciseWithImages, ExerciseAdapterDb.ViewHolder>(ExerciseWithImages.DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExerciseItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener , onSharedListener)
    }

    //remover
    //override fun getItemCount() = exercisesList.size

    class ViewHolder(
        val binding: ExerciseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            exercises: ExerciseWithImages?,
            onClickListener: (exercises: ExerciseWithImages) -> Unit,
            onSharedListener: (bitmap : Bitmap) -> Unit
        ) {

            with(binding) {
                exercises?.let {
                    binding?.ibExercise?.setOnClickListener {
                        onSharedListener(getBitmapFromView(cvExercise)!!)
                    }

                    tvExercise.text = exercises.exercise.name
                    cvExercise.setOnClickListener {
                        onClickListener(exercises)
                    }
                    //se imagem nao for null, carrega primeira imagem da lista
                    Glide
                        .with(itemView.context)
                        .load(exercises.image.firstOrNull()?.image)
                        .placeholder(R.drawable.noimage)
                        .into(ivExercise)
                }

            }
        }

        fun getBitmapFromView(view: View): Bitmap? {
            view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
            val bitmap = Bitmap.createBitmap(
                view.measuredWidth, view.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            view.layout(0, 0, view.measuredWidth, view.measuredHeight)
            view.draw(canvas)
            return bitmap
        }

    }
    }

