package com.example.digitalfit.ui.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkoutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Treinos"
    }
    val text: LiveData<String> = _text
}