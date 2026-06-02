package com.example.mynotes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mynotes.ui.navigation.AppNavigation
import com.example.mynotes.ui.theme.MyNotesTheme
import com.example.mynotes.ui.viewmodels.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNotesTheme {
                val viewModel: NotesViewModel = hiltViewModel()
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}
