package com.example.di.db

import app.cash.sqldelight.db.SqlDriver
import com.example.di.NoteDatabase
import migrations.NotesDb

class DatabaseHelper(sqlDriver: SqlDriver) {
    private val database = NoteDatabase(sqlDriver)

    fun fetchAllNotes(): List<NotesDb> = database.noteQueries.selectAll().executeAsList()

    fun insertNotes(id: String, title: String, description: String) =
        database.noteQueries.insertNote(id, title, description)
}