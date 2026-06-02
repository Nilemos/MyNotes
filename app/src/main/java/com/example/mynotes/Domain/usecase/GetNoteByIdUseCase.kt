package com.example.mynotes.Domain.usecase

import com.example.mynotes.Domain.model.Note
import com.example.mynotes.Domain.repository.NotesRepository

class GetNoteByIdUseCase(
    private val repository: NotesRepository
) {
    suspend fun execute(id: Long): Note? {
        return repository.getNoteById(id)
    }
}
