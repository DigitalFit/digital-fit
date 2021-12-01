package com.example.digitalfit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.digitalfit.databinding.ActivityMainBinding
import com.example.digitalfit.features.exercises.view.ExercisesFragment
import com.example.digitalfit.features.workout.view.Refresh

interface Acesso{
    fun acessar()
}

class MainActivity : AppCompatActivity(), Acesso {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        setupWithNavController(binding.bottomNavigation, navController)
        navController.saveState()


    }

    //metodo criado para ter acesso ao WorkoutFragment a partir do WorkoutCreateDialog
    override fun acessar() {
       val ref = supportFragmentManager.fragments.first().childFragmentManager.fragments.first() as Refresh
        ref.refresh()
    }


}
