package com.example.noteapp.feature_note.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.ui.theme.*

@Entity(tableName = "note")
data class Note(
    var title: String,
    var content: String,
    var timestamp: Long,
    var color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        var notesColor =
            listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen, DarkGray, LightBlue)
    }
}

class InvalidNoteException(message: String) : Exception(message)
