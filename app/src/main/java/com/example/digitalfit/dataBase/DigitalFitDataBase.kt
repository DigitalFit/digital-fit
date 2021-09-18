package com.example.digitalfit.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.digitalfit.modelDb.Exercise

object DigitalFitDataBase {

    @Database(entities = [Exercise::class], version =1)
    abstract class DigitalFitRoomDatabase : RoomDatabase() {
        abstract fun exerciseDao(): ExerciseDao
    }

    fun getDatabase(context: Context): DigitalFitRoomDatabase {
        return Room.databaseBuilder(
            context,
            DigitalFitRoomDatabase::class.java, "digitalFit_db"
        ). build()
    }
}