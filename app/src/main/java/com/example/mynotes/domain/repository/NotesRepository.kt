package com.example.mynotes.domain.repository

import com.example.mynotes.domain.model.Note

interface NotesRepository {
    suspend fun getAllNotes(): List<Note>
    suspend fun getNoteById(id: Long): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(id: Long)
}