package com.example.digitalfit.features.exercisedetail.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.digitalfit.R
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.FragmentExerciseDetailBinding
import com.example.digitalfit.features.exercisedetail.viewmodel.ExerciseDetailViewModel
import com.example.digitalfit.utils.Command
import com.example.digitalfit.utils.ConstantsApp.Exercise.KEY_BUNDLE_EXERCISE_ID


class ExerciseDetailFragment() : BaseFragment() {

    private var binding: FragmentExerciseDetailBinding? = null

    private val exerciseId: Int by lazy {
        arguments?.getInt(KEY_BUNDLE_EXERCISE_ID) ?: -1
    }

    private lateinit var viewModel: ExerciseDetailViewModel

    override var command: MutableLiveData<Command> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it)[ExerciseDetailViewModel::class.java]

            viewModel.command = command

           // viewModel.getExerciseById(exerciseId)

            viewModel.getExerciseWithImagesFromDbById(exerciseId)
            viewModel.getExerciseWithMusclesFromDbById(exerciseId)
            viewModel.getExerciseWithMusclesSecondaryFromDbById(exerciseId)

            setupObservables()
        }
    }

    private fun setupObservables() {
//        viewModel.onSuccessExerciseById.observe(viewLifecycleOwner, {
//            it?.let {exercise ->
//                binding?.let { bindingNonNull ->
//                    with(bindingNonNull){
//                        activity?.let { activityNonNull ->
//                            Glide
//                                .with(activityNonNull)
//                                .load(exercise.images.firstOrNull()?.image)
//                                .placeholder(R.drawable.noimage)
//                                .into(ivExerciseImage)
//                        }
//                        tvExerciseName.text = exercise.name
//                        tvDescriptionValue.text = exercise.description
//
//                        val muscleList = mutableListOf<String>()
//                        val separator = " - "
//
//                        exercise.muscles.forEach { muscle ->
//                            muscleList.add(muscle.name)
//                        }
//                        tvPrimaryMuscleValue.text = muscleList.joinToString(separator)
//
//                        muscleList.clear()
//                        exercise.muscles_secondary.forEach { muscle ->
//                            muscleList.add(muscle.name)
//                        }
//                        tvSecondaryMuscleValue.text = muscleList.joinToString(separator)
//                    }
//                }
//            }
//        })

        viewModel.onSuccessExerciseWithImagesFromDbById.observe(viewLifecycleOwner, {
            it?.let {exercise ->
                binding?.let { bindingNonNull ->
                    with(bindingNonNull){
                        activity?.let { activityNonNull ->
                            Glide
                                .with(activityNonNull)
                                .load(exercise.image.firstOrNull()?.image)
                                .placeholder(R.drawable.noimage)
                                .into(ivExerciseImage)
                        }
                        tvExerciseName.text = exercise.exercise.name
                        tvDescriptionValue.text = exercise.exercise.description
                    }
                }
            }
        })

        viewModel.onSuccessExerciseWithMusclesFromDbById.observe(viewLifecycleOwner, {
            it?.let {exercise ->
                binding?.let { bindingNonNull ->
                    with(bindingNonNull){

                        val muscleList = mutableListOf<String>()
                        val separator = " - "


                        exercise.forEach { exerciseWithMuscle ->
                            exerciseWithMuscle.muscle.forEach { muscle ->
                                muscle.name?.let{ muscleName ->
                                    muscleList.add(muscleName)
                                }
                            }
                        }
                        tvPrimaryMuscleValue.text = muscleList.joinToString(separator)
                    }
                }
            }
        })

        viewModel.onSuccessExerciseWithMusclesSecondaryFromDbById.observe(viewLifecycleOwner, {
            it?.let {exercise ->
                binding?.let { bindingNonNull ->
                    with(bindingNonNull){

                        val muscleList = mutableListOf<String>()
                        val separator = " - "

                        exercise.forEach { exerciseWithMuscleSecondary ->
                            exerciseWithMuscleSecondary.musclesSecondary.forEach { muscle ->
                                muscle.name?.let{ muscleName ->
                                    muscleList.add(muscleName)
                                }
                            }
                        }
                        tvSecondaryMuscleValue.text = muscleList.joinToString(separator)
                    }
                }
            }
        })

        viewModel.command.observe(viewLifecycleOwner, {
            when(it){
                is Command.Loading -> {

                }
                is Command.Error -> {

                }
            }
        })

        binding?.ibBackIcon?.setOnClickListener {
            activity?.onBackPressed()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}