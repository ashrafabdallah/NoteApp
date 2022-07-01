package com.example.noteapp.feature_note.domain.usecase

import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepository

class GetNoteByIdUseCase(private val noteRepository: NoteRepository) {
    suspend fun ececuteGetNoteByIdUse(id :Int):Note?{
        return noteRepository.getNoteById(id)
    }
}