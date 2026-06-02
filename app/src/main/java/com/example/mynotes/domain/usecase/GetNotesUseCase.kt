package com.example.mynotes.domain.usecase

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NotesRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NotesRepository
){
    suspend fun execute(): List<Note> {
        return repository.getAllNotes()
    }
}