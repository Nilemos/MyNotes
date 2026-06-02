package com.example.mynotes.Domain.usecase

import com.example.mynotes.Domain.model.Note
import com.example.mynotes.Domain.repository.NotesRepository

class AddNotesUseCase(
    private val repository: NotesRepository
){
    suspend fun execute(note: Note){
        repository.insertNote(note)
    }
}