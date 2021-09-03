package com.example.digitalfit.features.init

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.digitalfit.databinding.FragmentInitBinding

class InitFragment : Fragment() {

    private lateinit var initViewModel: InitViewModel
    private var _binding: FragmentInitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel =
            ViewModelProvider(this).get(InitViewModel::class.java)

        _binding = FragmentInitBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textInit
        initViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}