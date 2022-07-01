package com.example.noteapp.feature_note.data.repository

import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.data.repository.data_source.LocalDataSource
import com.example.noteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryIMPL(private val localDataSource: LocalDataSource) : NoteRepository {
    override fun getAllNote(): Flow<List<Note>> {
        return localDataSource.getAllNote()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return localDataSource.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        localDataSource.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        localDataSource.deleteNote(note)
    }
}