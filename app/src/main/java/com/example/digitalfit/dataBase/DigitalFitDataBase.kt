package com.example.digitalfit.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.digitalfit.modelDb.*

object DigitalFitDataBase {

    @Database(
        entities = [
            ExerciseDb::class,
            CategoryDb::class,
            CommentDb::class,
            EquipmentDb::class,
            ExerciseEquipmentCrossRef::class,
            ImageDb::class,
            LanguageDb::class,
            LicenseDb::class,
            MuscleDb::class,
            ExerciseMuscleCrossRef::class,
            ExerciseMuscleSecondaryCrossRef::class,
            WorkoutDb::class
        ],
        version =1
    )
    abstract class DigitalFitRoomDatabase : RoomDatabase() {
        abstract fun exerciseDao(): ExerciseDao
        abstract fun categoryDao(): CategoryDao
        abstract fun commentDao(): CommentDao
        abstract fun equipmentDao(): EquipmentDao
        abstract fun exerciseEquipmentDao(): ExerciseEquipmentCrossRefDao
        abstract fun imageDao(): ImageDao
        abstract fun languageDao(): LanguageDao
        abstract fun licenseDao(): LicenseDao
        abstract fun muscleDao(): MuscleDao
        abstract fun exerciseMuscleDao(): ExerciseMuscleCrossRefDao
        abstract fun exerciseMuscleSecondaryDao(): ExerciseMuscleSecondaryCrossRefDao
        abstract fun workoutDao(): WorkoutDao
    }

    fun getDatabase(context: Context): DigitalFitRoomDatabase {
        return Room.databaseBuilder(
            context,
            DigitalFitRoomDatabase::class.java, "digitalFit_db"
        ). build()
    }
}