package com.example.digitalfit.ui.exercises

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalfit.R

class exer2Fragment : Fragment() {

    companion object {
        fun newInstance() = exer2Fragment()
    }

    private lateinit var viewModel: Exer2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exer2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Exer2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
}