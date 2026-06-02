package com.example.mynotes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.mynotes.Data.database.NoteDatabase
import com.example.mynotes.Data.repository.NotesRepositoryImpl
import com.example.mynotes.Domain.usecase.AddNotesUseCase
import com.example.mynotes.Domain.usecase.GetNotesUseCase
import com.example.mynotes.ui.navigation.AppNavigation
import com.example.mynotes.ui.theme.MyNotesTheme
import com.example.mynotes.ui.viewmodels.NotesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Manual DI for simplicity, in a real app use Hilt or Koin
        val db = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "notes-database"
        ).build()
        
        val repository = NotesRepositoryImpl(db.noteDao())
        val getNotesUseCase = GetNotesUseCase(repository)
        val addNotesUseCase = AddNotesUseCase(repository)
        val viewModel = NotesViewModel(getNotesUseCase, addNotesUseCase)

        enableEdgeToEdge()
        setContent {
            MyNotesTheme {
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}
