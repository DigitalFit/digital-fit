package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.*

@Dao
interface EquipmentDao {

        @Query("SELECT * FROM equipment")
        suspend fun getAllEquipment(): List<Equipment>

        @Query("SELECT * FROM equipment WHERE equipmentId = :equipmentId")
        suspend fun loadEquipmentById (equipmentId: Int): List<Equipment>

        @Transaction
        @Query("SELECT * FROM Exercise")
        fun getExerciseWithEquipment(): List<Equipment>

        @Transaction
        @Query("SELECT * FROM Equipment")
        fun getEquipmentWithExercise(): List<Exercise>

         @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllEquipments (equipmentsList: List<Equipment>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertEquipment (equipment: Equipment)

        @Delete
        suspend fun delete(equipment: Equipment)
    }
