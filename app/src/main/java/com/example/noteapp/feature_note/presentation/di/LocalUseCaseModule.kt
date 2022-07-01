package com.example.noteapp.feature_note.presentation.di

import com.example.noteapp.feature_note.domain.repository.NoteRepository
import com.example.noteapp.feature_note.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalUseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(noteRepository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getAllNoteUseCase = GetAllNoteUseCase(noteRepository),
            getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository),
            insertNoteUseCase = InsertNoteUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository)
        )
    }

}