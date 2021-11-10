package com.example.digitalfit.features.exercises.view

import com.example.digitalfit.features.exercises.viewmodel.ExercisesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.R
import com.example.digitalfit.adapterAPI.ExerciseAdapterApi
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.databinding.FragmentExercisesBinding
import com.example.digitalfit.utils.Command
import com.example.digitalfit.utils.ConstantsApp.Exercise.KEY_BUNDLE_EXERCISE_ID
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.widget.SearchView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.paging.PagedList
import com.example.digitalfit.adapterAPI.ExerciseAdapterDb
import com.example.digitalfit.adapterAPI.SearchAdapter
import com.example.digitalfit.modelDb.ExerciseWithImages


class ExercisesFragment : BaseFragment() {

    private var binding: FragmentExercisesBinding? = null
    private lateinit var viewModel: ExercisesViewModel

    private val exercisesAdapterDb: ExerciseAdapterDb by lazy {
        ExerciseAdapterDb { exercises ->
            val bundle = Bundle()
            exercises.exercise.exerciseId.let { bundle.putInt(KEY_BUNDLE_EXERCISE_ID, it) }
            findNavController().navigate(
                R.id.action_navigation_exercises_to_exerciseDetailFragment,
                bundle
            )
        }
    }

    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter { exercises ->
            val bundle = Bundle()
            exercises.exercise.exerciseId?.let { bundle.putInt(KEY_BUNDLE_EXERCISE_ID, it) }
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

            viewModel.getExerciseEntities()

            initSearch()
            setupObeservables()
            setupRecyclerView()
        }
    }

    private fun loadContent() {
        viewModel.exercisesPagedList?.observe(viewLifecycleOwner, {
            exercisesAdapterDb.submitList(it)
        })
    }

    private fun setupObeservables() {
        //chamando api InfoExercise
        //chamando api ListExercise por id

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
        }
        )
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
            adapter = exercisesAdapterDb
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

