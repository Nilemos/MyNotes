package com.example.mynotes.Domain.repository

import com.example.mynotes.Domain.model.Note

interface NotesRepository {
    suspend fun getAllNotes(): List<Note>
    suspend fun getNoteById(id: Long): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(id: Long)
}