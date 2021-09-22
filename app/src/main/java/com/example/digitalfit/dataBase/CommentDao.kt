package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.Comment

@Dao
interface CommentDao {
    @Query("SELECT * FROM comment")
    suspend fun getAllComment(): List<Comment>

    @Query("SELECT * FROM comment WHERE commentId = :commentId")
    suspend fun loadCommentById (commentId: Int): List<Comment>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithComments(): List<Comment>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllComments (commentsList: List<Comment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment (comment: Comment)

    @Delete
    suspend fun delete(comment: Comment)
}