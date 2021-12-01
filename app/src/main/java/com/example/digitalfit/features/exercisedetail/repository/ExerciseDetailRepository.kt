package com.example.digitalfit.features.exercisedetail.repository

import android.app.Application
import com.example.digitalfit.api.ApiService
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWithMuscle
import com.example.digitalfit.modelDb.ExerciseWithMusclesSecondary
import com.example.digitalfit.utils.ResponseApi

class ExerciseDetailRepository(
    private val application: Application
) : BaseRepository() {

    suspend fun getExercisesWithImagesFromDbById(exerciseId: Int) =
        DigitalFitDataBase.getDatabase(application)
            .exerciseDao().getExerciseWithImagesById(exerciseId)


    suspend fun getExercisesWithMusclesFromDbById(exerciseId: Int) =
        DigitalFitDataBase.getDatabase(application)
            .exerciseMuscleDao().getExerciseWithMuscleById(exerciseId)


    suspend fun getExercisesWithMusclesSecondaryFromDbById(exerciseId: Int) =
        DigitalFitDataBase.getDatabase(application)
            .exerciseMuscleSecondaryDao().getExerciseWithMuscleSecondaryById(exerciseId)
}