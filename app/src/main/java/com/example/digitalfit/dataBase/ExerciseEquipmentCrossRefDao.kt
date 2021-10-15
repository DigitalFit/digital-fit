package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.EquipmentWithExercise
import com.example.digitalfit.modelDb.ExerciseEquipmentCrossRef
import com.example.digitalfit.modelDb.ExerciseWithEquipment

@Dao
interface ExerciseEquipmentCrossRefDao {

    @Transaction
    @Query("SELECT * FROM exercise")
    suspend fun getExerciseWithEquipment(): List<ExerciseWithEquipment>

    @Transaction
    @Query("SELECT * FROM equipment")
    suspend fun getEquipmentWithExercise(): List<EquipmentWithExercise>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllExerciseEquipment(exerciseEquipmentList: List<ExerciseEquipmentCrossRef>)

    @Insert(onConflict = REPLACE)
    suspend fun insertExerciseEquipment(exerciseEquipment: ExerciseEquipmentCrossRef)

    @Delete
    suspend fun delete(exerciseEquipment: ExerciseEquipmentCrossRef)
}