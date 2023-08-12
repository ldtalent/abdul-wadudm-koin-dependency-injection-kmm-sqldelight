package com.example.di.data

import com.example.di.db.DatabaseHelper
import com.example.di.domain.Notes
import com.example.di.domain.UUID
import migrations.NotesDb

class NotesRepository(private val databaseHelper: DatabaseHelper) {

    val notes: List<Notes>
        get() = databaseHelper.fetchAllNotes().map { it.asNotes() }

    fun insertNote(title: String, description: String) {
        databaseHelper.insertNotes(
            id = UUID().toString(),
            title = title,
            description = description
        )
    }

    private fun NotesDb.asNotes(): Notes {
        return Notes(
            id, title, description
        )
    }

}