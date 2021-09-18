package com.example.digitalfit.features.exercises.view

import ExercisesViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.R
import com.example.digitalfit.adapterAPI.ExerciseAdapterApi
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.FragmentExercisesBinding
import com.example.digitalfit.utils.Command
import com.example.digitalfit.utils.ConstantsApp.Exercise.KEY_BUNDLE_EXERCISE_ID
import com.google.android.material.snackbar.Snackbar


class ExercisesFragment : BaseFragment() {

    private var binding: FragmentExercisesBinding? = null
    private lateinit var viewModel: ExercisesViewModel

    private val exercisesAdapterApi: ExerciseAdapterApi by lazy{
        ExerciseAdapterApi { exercises ->
            val bundle = Bundle()
            bundle.putInt(KEY_BUNDLE_EXERCISE_ID, exercises.id)
            findNavController().navigate(
                R.id.action_navigation_exercises_to_exerciseDetailFragment,
                bundle
            )
        }
    }

    override var command: MutableLiveData<Command> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExercisesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it)[ExercisesViewModel::class.java]

            viewModel.command = command

            viewModel.getInfoExercises()

//            viewModel.getListExercises()
//            viewModel.getImageExercises()
//            viewModel.getCategoryExercises()
//            viewModel.getCommentExercises()


            setupObeservables()
            setupRecyclerView()
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    private fun setupObeservables() {
        //chamando api InfoExercise
        //chamando api ListExercise por id

        viewModel.exercisesPagedList?.observe(viewLifecycleOwner, {
            exercisesAdapterApi.submitList(it)
        })
        binding?.vgExerciseRecyclerView?.adapter?.stateRestorationPolicy =
                            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

//        viewModel.onSuccessInfoExercises.observe(viewLifecycleOwner, {
//            it?.let { exercisesList ->
//                val exercisesAdapterApi = ExerciseAdapterApi(
//                    exercisesList = exercisesList
//                ) { exercises ->
//                    val bundle = Bundle()
//                    bundle.putInt(KEY_BUNDLE_EXERCISE_ID, exercises.id)
//                    findNavController().navigate(R.id.action_navigation_exercises_to_exerciseDetailFragment,
//                    bundle)
//                }
//
//                binding?.let {
//                    with(it) {
//                        vgExerciseRecyclerView.apply {
//                            layoutManager = LinearLayoutManager(context)
//                            adapter = exercisesAdapterApi
//                        }
//
//
//                    }
//                }
//            }
//        }
//        )

//        viewModel.onSuccessListExercises.observe(viewLifecycleOwner, {
//            it?.let { exercisesList ->
//                val exercisesAdapterApi = ExerciseAdapterApi(
//                    exercisesList = exercisesList
//                ) { exercises ->
//                    viewModel.getExerciseById(exercises.id)
//                }
//
//                binding?.let {
//                    with(it) {
//
//                        }
//                    }
//                }
//            }
//        }
//        )

//        viewModel.onErrorListExercises.observe(viewLifecycleOwner, {
//            viewLifecycleOwner
//        })

        viewModel.command.observe(viewLifecycleOwner, {
            when (it) {
                is Command.Loading -> {

                }
                is Command.Error -> {
                    binding?.let { bindingNonNull ->
                        Snackbar.make(
                            bindingNonNull.vgExerciseRecyclerView,
                            getString(it.error),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        )

        binding?.let {
            with(it) {
                chAll.setOnClickListener {
                    findNavController().navigate(R.id.action_navigation_exercises_to_bottomSheetFilterFragment)
                }
                chMuscleGroups.setOnClickListener {
                    findNavController().navigate(R.id.action_navigation_exercises_to_bottomSheetMusclesFragment)
                }
                chEquipments.setOnClickListener {
                    findNavController().navigate(R.id.action_navigation_exercises_to_bottomSheetEquipmentsFragment)
                }
                ibAdd.setOnClickListener {
                    findNavController().navigate(R.id.action_navigation_exercises_to_exercisesAddFragment)
                }
            }
        }
    }

    private fun setupRecyclerView(){
        binding?.vgExerciseRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exercisesAdapterApi
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}