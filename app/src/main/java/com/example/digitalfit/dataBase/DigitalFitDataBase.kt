package com.example.digitalfit.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.digitalfit.modelDb.Exercise

object DigitalFitDataBase {

    @Database(entities = [Exercise::class, CategoryDao::class, CommentDao::class, EquipmentDao::class,ImageDao::class,LanguageDao::class,LicenseDao::class,MuscleDao::class,MusclesSecondarySecondaryDao::class], version =1)
    abstract class DigitalFitRoomDatabase : RoomDatabase() {
        abstract fun exerciseDao(): ExerciseDao
        abstract fun categoryDao(): CategoryDao
        abstract fun commentDao(): CommentDao
        abstract fun equipmentDao(): EquipmentDao
        abstract fun imageDao(): ImageDao
        abstract fun languageDao(): LanguageDao
        abstract fun licenseDao(): LicenseDao
        abstract fun muscleDao(): MuscleDao
        abstract fun musclesSecondaryDao(): MusclesSecondarySecondaryDao
    }

    fun getDatabase(context: Context): DigitalFitRoomDatabase {
        return Room.databaseBuilder(
            context,
            DigitalFitRoomDatabase::class.java, "digitalFit_db"
        ). build()
    }
}