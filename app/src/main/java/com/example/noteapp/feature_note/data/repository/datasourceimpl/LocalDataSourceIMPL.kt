package com.example.noteapp.feature_note.data.repository.datasourceimpl

import com.example.noteapp.feature_note.data.db.NoteDao
import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.data.repository.data_source.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceIMPL(private val noteDao: NoteDao) :LocalDataSource{
    override fun getAllNote(): Flow<List<Note>> {
        return noteDao.getAllNote()
    }

    override suspend fun getNoteById(id: Int): Note? {
       return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
       noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
       noteDao.deleteNote(note)
    }

}