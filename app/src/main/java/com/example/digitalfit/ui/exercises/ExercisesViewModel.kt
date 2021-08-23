package com.example.digitalfit.ui.exercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExercisesViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "Exercícios"
    }
    val text: LiveData<String> = _text
}
