package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    suspend fun getAllCategory(): List<Category>

    @Query("SELECT * FROM category WHERE categoryId = :categoryId")
    suspend fun loadCategoryById (categoryId: Int): List<Category>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithCategory(): Category

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategory (categoryList: List<Category>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory (category: Category)

    @Delete
    suspend fun delete(category: Category)
    
    
}