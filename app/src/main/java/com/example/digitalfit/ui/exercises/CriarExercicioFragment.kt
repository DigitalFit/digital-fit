package com.example.digitalfit.ui.exercises

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalfit.R

class criarExercicioFragment : Fragment() {

    companion object {
        fun newInstance() = criarExercicioFragment()
    }

    private lateinit var viewModel: CriarExercicioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.criar_exercicio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CriarExercicioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}