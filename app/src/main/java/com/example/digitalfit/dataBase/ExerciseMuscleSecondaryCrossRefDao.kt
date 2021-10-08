package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.*

@Dao
interface ExerciseMuscleSecondaryCrossRefDao {

    @Transaction
    @Query("SELECT * FROM exercise")
    fun getExerciseWithMuscleSecondary(): List<ExerciseWithMusclesSecondary>

    @Transaction
    @Query("SELECT * FROM exercise WHERE exerciseId = :exerciseId")
    fun getExerciseWithMuscleSecondaryById(exerciseId: Int): List<ExerciseWithMusclesSecondary>

    @Transaction
    @Query("SELECT * FROM muscle")
    fun getMuscleSecondaryWithExercise(): List<MusclesSecondaryWithExercise>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllExerciseMuscleSecondary(exerciseMuscleSecondaryList: List<ExerciseMuscleSecondaryCrossRef>)

    @Insert(onConflict = REPLACE)
    suspend fun insertExerciseMuscleSecondary(exerciseMuscleSecondary: ExerciseMuscleSecondaryCrossRef)

    @Delete
    suspend fun delete(exerciseMuscleSecondary: ExerciseMuscleSecondaryCrossRef)
}