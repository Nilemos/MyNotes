package com.example.mynotes.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynotes.Domain.model.Note
import com.example.mynotes.Domain.usecase.AddNotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.mynotes.Domain.usecase.GetNotesUseCase

class NotesViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNotesUseCase
): ViewModel(){

    private val _state = MutableStateFlow(NotesState())
    val state = _state.asStateFlow()

    init {
        loadNotes()
    }

    fun loadNotes(){
        viewModelScope.launch {
            _state.value  = _state.value.copy(isLoading = true)

            val notes = getNotesUseCase.execute()

            _state.value = NotesState(notes = notes, isLoading = false)
        }
    }

    fun onAddNoteClicked() {
        viewModelScope.launch {
            addNoteUseCase.execute(
                Note(
                    title = "New Note",
                    id = 0,
                    text = "This is a new note",
                    category = "General",
                    imagePath = null,
                )
            )
            loadNotes()
        }
    }

    fun onUpdateNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase.execute(note) // insertNote with REPLACE works as update
            loadNotes()
        }
    }

    suspend fun getNoteById(id: Long): Note? {
        // This is a bit of a hack since we are using GetNotesUseCase but not a dedicated GetNoteById one here
        // In a real app, you'd probably have this in the ViewModel state or use a separate UseCase
        return state.value.notes.find { it.id == id }
    }
}