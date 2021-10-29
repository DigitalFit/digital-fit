package com.example.digitalfit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.digitalfit.databinding.ActivityMainBinding
import com.example.digitalfit.features.exercises.view.ExercisesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        setupWithNavController(binding.bottomNavigation, navController)
        navController.saveState()

    }


}
