package com.example.noteapp.feature_note.presentation.notes

import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.domain.util.NoteOrder

sealed class NotesEvents {
    data class Order(val noteOrder: NoteOrder) : NotesEvents()
    data class DeleteNotes(val note: Note) : NotesEvents()
    object RestoreNote : NotesEvents()
    object ToggleOrderSection : NotesEvents()
}
