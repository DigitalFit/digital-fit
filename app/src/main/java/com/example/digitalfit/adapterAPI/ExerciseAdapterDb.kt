import android.os.Looper
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.digitalfit.R
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.modelApi.ResultInfo
import com.example.digitalfit.modelDb.ExerciseDb
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.selects.whileSelect
import java.util.Timer
import kotlin.concurrent.schedule


class ExerciseAdapterDb(
    //private val exercisesList: List<ResultInfo>,
    private val onClickListener: (exercises: ExerciseWithImages) -> Unit
//) : RecyclerView.Adapter<ExerciseAdapterApi.ViewHolder>() {
) : PagedListAdapter<ExerciseWithImages, ExerciseAdapterDb.ViewHolder>(ExerciseWithImages.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExerciseItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }

    //remover
    //override fun getItemCount() = exercisesList.size

    class ViewHolder(
        val binding: ExerciseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            exercises: ExerciseWithImages?,
            onClickListener: (exercises: ExerciseWithImages) -> Unit,
        ) {
            with(binding) {
                exercises?.let {
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
    }
}
