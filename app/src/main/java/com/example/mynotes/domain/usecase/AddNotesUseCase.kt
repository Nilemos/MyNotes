package com.example.mynotes.domain.usecase

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NotesRepository
import javax.inject.Inject

class AddNotesUseCase @Inject constructor(
    private val repository: NotesRepository
){
    suspend fun execute(note: Note){
        repository.insertNote(note)
    }
}