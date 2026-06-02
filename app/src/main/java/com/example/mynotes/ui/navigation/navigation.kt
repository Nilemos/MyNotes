package com.example.mynotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mynotes.ui.screens.NotesScreen
import com.example.mynotes.ui.screens.SingleNote
import com.example.mynotes.ui.viewmodels.NotesViewModel

@Composable
fun AppNavigation(viewModel: NotesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen"){
        composable("home_screen") { 
            NotesScreen(viewModel, navController) 
        }
        composable(
            route = "single_note_screen/{noteId}/{noteTitle}/{noteText}",
            arguments = listOf(
                navArgument("noteId") { type = NavType.LongType },
                navArgument("noteTitle") { type = NavType.StringType },
                navArgument("noteText") {type = NavType.StringType}
            )
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getLong("noteId")
            val noteTitle = backStackEntry.arguments?.getString("noteTitle")
            val noteText = backStackEntry.arguments?.getString("noteText")
            SingleNote(
                noteId = noteId, 
                noteTitle = noteTitle, 
                noteText = noteText,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}