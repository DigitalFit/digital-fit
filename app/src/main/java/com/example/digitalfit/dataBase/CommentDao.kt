package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.CommentDb
import com.example.digitalfit.modelDb.ExerciseWithComments

@Dao
interface CommentDao {
    @Query("SELECT * FROM comment")
    suspend fun getAllComment(): List<CommentDb>

    @Query("SELECT * FROM comment WHERE commentId = :commentId")
    suspend fun loadCommentById (commentId: Int): List<CommentDb>

    @Transaction
    @Query("SELECT * FROM exercise")
    fun getExerciseWithComments(): List<ExerciseWithComments>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllComments (commentsList: List<CommentDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment (comment: CommentDb)

    @Delete
    suspend fun delete(comment: CommentDb)
}