package com.example.mynotes.ui.viewmodels

import com.example.mynotes.domain.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false
)

