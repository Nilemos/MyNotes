package com.example.mynotes.Domain.model

data class Note(
    val id: Long,
    val title: String,
    val text: String,
    val category: String?,
    val imagePath: String?
)
