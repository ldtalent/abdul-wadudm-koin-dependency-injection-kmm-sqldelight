package com.example.di.android.screen

import androidx.compose.runtime.Composable
import com.example.di.viewmodel.NotesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NotesScreen(notesViewModel: NotesViewModel = koinViewModel()) {

}