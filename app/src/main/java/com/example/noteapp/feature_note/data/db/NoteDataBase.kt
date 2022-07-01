package com.example.noteapp.feature_note.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.feature_note.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase :RoomDatabase(){
    abstract val  getNoteDao: NoteDao
}