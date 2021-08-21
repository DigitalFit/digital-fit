package com.example.digitalfit.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.digitalfit.databinding.FragmentNutritionBinding

class NutritionFragment : Fragment() {

    private lateinit var nutritionViewModel: NutritionViewModel
    private var _binding: FragmentNutritionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nutritionViewModel =
            ViewModelProvider(this).get(NutritionViewModel::class.java)

        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNutrition
        nutritionViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}