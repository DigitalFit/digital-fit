package com.example.digitalfit.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.utils.Command

abstract class BaseFragment: Fragment() {


    abstract var command: MutableLiveData<Command>
}