package com.example.noteapp.feature_note.domain.repository

import com.example.noteapp.feature_note.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNote(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)

}