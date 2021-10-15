package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ImageDb

@Dao
interface ImageDao {

    @Query("SELECT * FROM image")
    suspend fun getAllImage(): List<ImageDb>

    @Query("SELECT * FROM image WHERE imageId = :imageId")
    suspend fun loadImageById (imageId: Int): List<ImageDb>

    @Query("SELECT * FROM image WHERE exerciseId = :exerciseId")
    suspend fun getImageByExerciseId (exerciseId: Int): List<ImageDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImages (imagesList: List<ImageDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage (image: ImageDb)

    @Delete
    suspend fun delete(image: ImageDb)
}