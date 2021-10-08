package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.*

@Dao
interface EquipmentDao {

        @Query("SELECT * FROM equipment")
        suspend fun getAllEquipment(): List<EquipmentDb>

        @Query("SELECT * FROM equipment WHERE equipmentId = :equipmentId")
        suspend fun loadEquipmentById (equipmentId: Int): List<EquipmentDb>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllEquipments (equipmentsList: List<EquipmentDb>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertEquipment (equipment: EquipmentDb)

        @Delete
        suspend fun delete(equipment: EquipmentDb)
    }
