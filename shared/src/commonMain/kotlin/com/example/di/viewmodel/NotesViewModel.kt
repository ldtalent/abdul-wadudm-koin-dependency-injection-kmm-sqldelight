package com.example.di.viewmodel

import com.example.di.data.NotesRepository
import com.example.di.domain.Notes
import com.example.di.util.BaseViewModel

class NotesViewModel (private val repository: NotesRepository): BaseViewModel() {

    fun getAllNotes(): List<Notes> = repository.notes

}