package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.ExerciseMuscleCrossRef
import com.example.digitalfit.modelDb.ExerciseWithMuscle
import com.example.digitalfit.modelDb.MuscleWithExercise

@Dao
interface ExerciseMuscleCrossRefDao {

    @Transaction
    @Query("SELECT * FROM exercise")
    fun getExerciseWithMuscle(): List<ExerciseWithMuscle>

    @Transaction
    @Query("SELECT * FROM exercise WHERE exerciseId = :exerciseId")
    fun getExerciseWithMuscleById(exerciseId: Int): List<ExerciseWithMuscle>

    @Transaction
    @Query("SELECT * FROM muscle")
    fun getMuscleWithExercise(): List<MuscleWithExercise>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllExerciseMuscle(exerciseMuscleList: List<ExerciseMuscleCrossRef>)

    @Insert(onConflict = REPLACE)
    suspend fun insertExerciseMuscle(exerciseMuscle: ExerciseMuscleCrossRef)

    @Delete
    suspend fun delete(exerciseMuscle: ExerciseMuscleCrossRef)
}