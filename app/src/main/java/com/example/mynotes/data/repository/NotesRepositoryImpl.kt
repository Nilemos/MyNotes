package com.example.mynotes.data.repository

import com.example.mynotes.data.database.NoteDao
import com.example.mynotes.data.database.NoteEntity
import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NotesRepository
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NotesRepository {
    override suspend fun getAllNotes(): List<Note> {
        return noteDao.getAll().map { entity ->
            Note(
                id = entity.id,
                title = entity.title,
                text = entity.text,
                category = entity.category,
                imagePath = entity.imagePath
            )
        }
    }

    override suspend fun getNoteById(id: Long): Note? {
        return noteDao.getById(id)?.let { entity ->
            Note(
                id = entity.id,
                title = entity.title,
                text = entity.text,
                category = entity.category,
                imagePath = entity.imagePath
            )
        }
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insert(
            NoteEntity(
                id = note.id,
                title = note.title,
                text = note.text,
                category = note.category,
                imagePath = note.imagePath
            )
        )
    }

    override suspend fun deleteNote(id: Long) {
        noteDao.deleteById(id)
    }
}