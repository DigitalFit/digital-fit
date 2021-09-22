package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.Image

@Dao
interface ImageDao {

    @Query("SELECT * FROM image")
    suspend fun getAllImage(): List<Image>

    @Query("SELECT * FROM image WHERE imageId = :imageId")
    suspend fun loadImageById (imageId: Int): List<Image>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithImage(): List<Image>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImages (imagesList: List<Image>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage (image: Image)

    @Delete
    suspend fun delete(image: Image)
}