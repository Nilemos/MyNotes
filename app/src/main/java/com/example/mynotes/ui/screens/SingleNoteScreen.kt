package com.example.mynotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mynotes.domain.model.Note
import com.example.mynotes.ui.viewmodels.NotesViewModel

@Composable
fun SingleNote(
    noteId: Long?,
    noteTitle: String?,
    noteText: String?,
    viewModel: NotesViewModel,
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf(noteTitle ?: "") }
    var text by remember { mutableStateOf(noteText ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Content") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (noteId != null) {
                    viewModel.onUpdateNote(
                        Note(
                            id = noteId,
                            title = title,
                            text = text,
                            category = null, // Or preserve existing category if you have it
                            imagePath = null
                        )
                    )
                    onBack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Changes")
        }
    }
}
