package com.example.noteapp.feature_note.domain.usecase

import com.example.noteapp.feature_note.data.model.InvalidNoteException
import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepository

class InsertNoteUseCase(private val noteRepository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend fun executeInsertNote(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the Note can`t be empty...")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The Content of the Note can`t be empty...")
        }
        noteRepository.insertNote(note)
    }
}