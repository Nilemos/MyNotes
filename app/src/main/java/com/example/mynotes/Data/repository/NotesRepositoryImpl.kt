package com.example.mynotes.Data.repository

import com.example.mynotes.Data.database.NoteDao
import com.example.mynotes.Data.database.NoteEntity
import com.example.mynotes.Domain.model.Note
import com.example.mynotes.Domain.repository.NotesRepository

class NotesRepositoryImpl(
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