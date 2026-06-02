package com.example.mynotes.Domain.usecase

import com.example.mynotes.Domain.model.Note
import com.example.mynotes.Domain.repository.NotesRepository

class GetNotesUseCase (
    private val repository: NotesRepository
){
    suspend fun execute(): List<Note> {
        return repository.getAllNotes()
    }
}