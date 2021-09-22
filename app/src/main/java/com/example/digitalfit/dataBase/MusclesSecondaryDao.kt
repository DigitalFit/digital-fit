package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.Exercise
import com.example.digitalfit.modelDb.Muscle
import com.example.digitalfit.modelDb.MusclesSecondary

@Dao
interface MusclesSecondarySecondaryDao {

    @Query("SELECT * FROM musclesSecondary")
    suspend fun getAllMusclesSecondary(): List<MusclesSecondary>

    @Query("SELECT * FROM MusclesSecondary WHERE musclesSecondaryId = :muscleSecondaryId")
    suspend fun loadMusclesSecondaryById (muscleSecondaryId: Int): List<MusclesSecondary>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithMuscleSecondary(): List<MusclesSecondary>

    @Transaction
    @Query("SELECT * FROM MusclesSecondary")
    fun getMuscleSecondaryWithExercise(): Exercise

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMusclesSecondary (muscleSecondaryList: List<MusclesSecondary>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMuscleSecondary (muscleSecondary: MusclesSecondary)

    @Delete
    suspend fun delete(muscleSecondary: MusclesSecondary)
}