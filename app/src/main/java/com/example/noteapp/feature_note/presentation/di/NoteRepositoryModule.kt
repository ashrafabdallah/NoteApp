package com.example.noteapp.feature_note.presentation.di

import com.example.noteapp.feature_note.data.repository.NoteRepositoryIMPL
import com.example.noteapp.feature_note.data.repository.data_source.LocalDataSource
import com.example.noteapp.feature_note.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NoteRepositoryModule {
    @Singleton
    @Provides
    fun provideNoteRepository(localDataSource: LocalDataSource) :NoteRepository{
        return NoteRepositoryIMPL(localDataSource)
    }
}