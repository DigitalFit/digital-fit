package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.*

@Dao
interface ExerciseMuscleSecondaryCrossRefDao {

    @Transaction
    @Query("SELECT * FROM exercise")
    suspend fun getExerciseWithMuscleSecondary(): List<ExerciseWithMusclesSecondary>

    @Transaction
    @Query("SELECT * FROM exercise WHERE exerciseId = :exerciseId")
    suspend fun getExerciseWithMuscleSecondaryById(exerciseId: Int): List<ExerciseWithMusclesSecondary>

    @Transaction
    @Query("SELECT * FROM muscle")
    suspend fun getMuscleSecondaryWithExercise(): List<MusclesSecondaryWithExercise>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllExerciseMuscleSecondary(exerciseMuscleSecondaryList: List<ExerciseMuscleSecondaryCrossRef>)

    @Insert(onConflict = REPLACE)
    suspend fun insertExerciseMuscleSecondary(exerciseMuscleSecondary: ExerciseMuscleSecondaryCrossRef)

    @Delete
    suspend fun delete(exerciseMuscleSecondary: ExerciseMuscleSecondaryCrossRef)
}