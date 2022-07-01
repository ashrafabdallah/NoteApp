package com.example.noteapp.feature_note.presentation.di

import com.example.noteapp.feature_note.data.db.NoteDao
import com.example.noteapp.feature_note.data.repository.data_source.LocalDataSource
import com.example.noteapp.feature_note.data.repository.datasourceimpl.LocalDataSourceIMPL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(noteDao: NoteDao): LocalDataSource {
        return LocalDataSourceIMPL(noteDao)
    }
}