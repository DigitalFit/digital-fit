package com.example.digitalfit.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.WorkoutDb

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workout")
    suspend fun getAllWorkouts(): List<WorkoutDb>

    //@Query("SELECT * FROM workout")
    //suspend fun getAll(): LiveData<List<WorkoutDb>>

    @Query("SELECT * FROM workout WHERE workoutId = :workoutId")
    suspend fun getWorkoutByIdFromDb(workoutId: Long): WorkoutDb

    @Insert
    suspend fun insert(workout: WorkoutDb)

    @Update
    suspend fun update(workout: WorkoutDb)

    @Delete
    suspend fun delete(workout: WorkoutDb)

    @Query("DELETE FROM exercise_workout WHERE workoutId = :workoutId" )
    suspend fun deleteExerciseList(workoutId: Long)

    @Transaction
    @Query("SELECT * FROM workout WHERE name LIKE :name")
    suspend fun searchWorkoutsByName(name: String?): List<WorkoutDb>
}