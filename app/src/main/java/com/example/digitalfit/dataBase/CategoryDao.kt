package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.CategoryDb
import com.example.digitalfit.modelDb.CategoryWithExercise

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    suspend fun getAllCategory(): List<CategoryDb>

    @Query("SELECT * FROM category WHERE categoryId = :categoryId")
    suspend fun loadCategoryById (categoryId: Int): List<CategoryDb>

    @Transaction
    @Query("SELECT * FROM category")
    fun getExerciseWithCategory(): List<CategoryWithExercise>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategory (categoryList: List<CategoryDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory (category: CategoryDb)

    @Delete
    suspend fun delete(category: CategoryDb)
    
    
}