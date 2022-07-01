package com.example.noteapp.feature_note.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp.feature_note.data.db.NoteDao
import com.example.noteapp.feature_note.data.db.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun providesDataBaseInstance(app: Application): NoteDataBase {
        return Room.databaseBuilder(app, NoteDataBase::class.java, "note_database").build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase): NoteDao {
        return noteDataBase.getNoteDao
    }
}