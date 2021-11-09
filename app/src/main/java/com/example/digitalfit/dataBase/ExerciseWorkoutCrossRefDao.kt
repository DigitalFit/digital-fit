package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.*

@Dao
interface ExerciseWorkoutCrossRefDao {
//    @Transaction
//    @Query("SELECT * FROM exercise_workout WHERE workoutId = :workoutId")
//    suspend fun getWorkoutWithExerciseById(workoutId: Long): List<ExerciseWithImages>

//    @Transaction
//    @Query("SELECT * FROM exercise_workout WHERE workoutId = :workoutId")
//    suspend fun getWorkoutWithExerciseById(workoutId: Long): WorkoutWithExerciseAndImages

    @Transaction
    @Query(
        "SELECT * FROM exercise INNER JOIN exercise_workout ON exercise.exerciseId = exercise_workout.exerciseId WHERE exercise_workout.workoutId = :workoutId"
    )
    suspend fun getWorkoutWithExerciseById(workoutId: Long): List<ExerciseWithImages>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseWorkout(exerciseWorkout: ExerciseWorkoutCrossRef)

    @Delete
    suspend fun delete(exerciseWorkout: ExerciseWorkoutCrossRef)
}