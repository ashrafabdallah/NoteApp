package com.example.noteapp.feature_note.domain.usecase

import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {
    suspend fun executeDeleteNote(note: Note){
        noteRepository.deleteNote(note)
    }
}