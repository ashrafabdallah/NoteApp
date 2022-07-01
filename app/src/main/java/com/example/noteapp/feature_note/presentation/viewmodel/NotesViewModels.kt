package com.example.noteapp.feature_note.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.feature_note.data.model.Note
import com.example.noteapp.feature_note.domain.usecase.NoteUseCase
import com.example.noteapp.feature_note.domain.util.NoteOrder
import com.example.noteapp.feature_note.domain.util.OrderType
import com.example.noteapp.feature_note.presentation.notes.NotesEvents
import com.example.noteapp.feature_note.presentation.notes.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteUseCase: NoteUseCase)
    : ViewModel() {
    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state
    private var recentlyDeleteNote: Note? = null
    private var getNotesJob: Job? = null

    init {

        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(events: NotesEvents) {
        when (events) {
            is NotesEvents.Order -> {
                if (state.value.noteOrder::class == events.noteOrder::class
                    && state.value.noteOrder.orderType == events.noteOrder.orderType
                ) {
                    return
                }
                getNotes(events.noteOrder)
            }

            is NotesEvents.DeleteNotes -> {
                viewModelScope.launch {
                    noteUseCase.deleteNoteUseCase.executeDeleteNote(events.note)
                    recentlyDeleteNote = events.note
                }
            }

            is NotesEvents.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCase.insertNoteUseCase.executeInsertNote(
                        recentlyDeleteNote ?: return@launch
                    )
                    recentlyDeleteNote = null
                }
            }
            is NotesEvents.ToggleOrderSection -> {

                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCase.getAllNoteUseCase(noteOrder = noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}