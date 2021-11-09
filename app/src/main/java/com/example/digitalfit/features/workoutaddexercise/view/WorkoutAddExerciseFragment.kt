package com.example.digitalfit.features.workoutaddexercise.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.R
import com.example.digitalfit.adapterAPI.*
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.databinding.FragmentWorkoutAddExerciseBinding
import com.example.digitalfit.databinding.WorkoutAddExerciseItemBinding
import com.example.digitalfit.features.exercises.viewmodel.ExercisesViewModel
import com.example.digitalfit.features.workout.view.WorkoutFragmentDirections
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.utils.Command
import com.example.digitalfit.utils.ConstantsApp
import com.google.android.material.snackbar.Snackbar

class WorkoutAddExerciseFragment: BaseFragment() {
    private var binding: FragmentWorkoutAddExerciseBinding? = null
    private lateinit var viewModel: ExercisesViewModel
    private var workoutId: Long = -1


    var pagedList: List<ExerciseWithImages>? = null


    private val workoutAddExerciseAdapterDb = WorkoutAddExerciseAdapterDb(
        onInsert = { exercise ->
            val exerciseWorkout = ExerciseWorkoutCrossRef(
                exerciseId = exercise,
                workoutId = workoutId
            )
            viewModel.addExerciseInWorkoutList(exerciseWorkout)
        },
        onDetail = { exercise ->
            findNavController().navigate(
                WorkoutAddExerciseFragmentDirections.actionWorkoutAddExerciseFragmentToExerciseDetailFragment(exercise.exercise.exerciseId)
            )
        }
    )


    private val searchAdapter = WorkoutAddExerciseSearchAdapter(
        onInsert = { exercise ->
            val exerciseWorkout = ExerciseWorkoutCrossRef(
                exerciseId = exercise,
                workoutId = workoutId
            )
            viewModel.addExerciseToWorkoutList(exerciseWorkout)
        },
        onDetail = { exercise ->
            findNavController().navigate(
                WorkoutAddExerciseFragmentDirections.actionWorkoutAddExerciseFragmentToExerciseDetailFragment(exercise.exercise.exerciseId)
            )
        }
    )


    override var command: MutableLiveData<Command> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args: WorkoutAddExerciseFragmentArgs by navArgs()
        workoutId = args.itemId

        binding = FragmentWorkoutAddExerciseBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        activity?.let {
            viewModel = ViewModelProvider(it)[ExercisesViewModel::class.java]

            viewModel.command = command


            viewModel.getExerciseEntities()


            initSearch()
            setupObeservables()
            setupRecyclerView()
        }
    }

    private fun loadContent() {
        viewModel.exercisesPagedList?.observe(viewLifecycleOwner, {
            pagedList = it.snapshot()
            workoutAddExerciseAdapterDb.submitList(it)
        })
    }

    private fun setupObeservables() {
        viewModel.onExerciseEntitiesLoaded.observe(viewLifecycleOwner, {
            binding?.progressBar?.isGone = true
            loadContent()
        })

        viewModel.onSuccessSearchExercisesByName.observe(viewLifecycleOwner, {
            searchAdapter.submitList(it)
        })



        binding?.vgExerciseRecyclerView?.adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY




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
        })

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

        viewModel.onSuccessAddExerciseToWorkoutList.observe(viewLifecycleOwner, { exerciseAdded ->
            if(exerciseAdded == true){
                Toast.makeText(context, "Exercício adicionado ao treino!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Este exercício já foi adicionado ao treino!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initSearch() {
        val searchView: SearchView? = binding?.searchBar

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != "") {
                    setupRecyclerViewVisibility(
                        isListFromSearchShowing = true
                    )
                    viewModel.searchExercisesByName("%$newText%")
                }else{
                    setupRecyclerViewVisibility(
                        isListFromSearchShowing = false
                    )
                }
                return false
            }
        })
    }

    private fun setupRecyclerView() {
        binding?.vgExerciseRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = workoutAddExerciseAdapterDb
        }

        binding?.vgSearchExerciseRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = searchAdapter
        }
    }

    private fun setupRecyclerViewVisibility(
        isListFromSearchShowing: Boolean
    ) {
        binding?.vgExerciseRecyclerView?.isVisible = !isListFromSearchShowing
        binding?.vgSearchExerciseRecyclerView?.isVisible = isListFromSearchShowing

//        binding?.vgExerciseRecyclerView?.isGone = !isListFromSearchShowing
//        binding?.vgSearchExerciseRecyclerView?.isGone = isListFromSearchShowing
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
