package com.example.noteapp.feature_note.domain.usecase

data class NoteUseCase(
    val getAllNoteUseCase: GetAllNoteUseCase, val getNoteByIdUseCase: GetNoteByIdUseCase,
    val insertNoteUseCase: InsertNoteUseCase, val deleteNoteUseCase: DeleteNoteUseCase
)
