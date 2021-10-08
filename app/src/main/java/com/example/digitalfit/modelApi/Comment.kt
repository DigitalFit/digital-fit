package com.example.digitalfit.modelApi

import com.example.digitalfit.modelDb.CommentDb

data class Comment(
    val comment: String,
    val exercise: Int,
    val id: Int
)

fun Comment.toCommentDb(): CommentDb {
    return CommentDb(
        commentId = this.id,
        comment = this.comment,
        exerciseId = this.exercise
    )
}