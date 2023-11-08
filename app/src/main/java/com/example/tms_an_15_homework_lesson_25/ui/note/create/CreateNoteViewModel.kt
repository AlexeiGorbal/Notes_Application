package com.example.tms_an_15_homework_lesson_25.ui.note.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_an_15_homework_lesson_25.model.Note
import com.example.tms_an_15_homework_lesson_25.repository.NoteRepository
import java.util.Date

class CreateNoteViewModel : ViewModel() {

    val uiState = MutableLiveData<UiState>()

    fun saveNote(title: String, text: String) {

        if (title.isBlank()) {
            uiState.value = UiState.WrongTitle()
        }

        if (text.isBlank()) {
            uiState.value = UiState.WrongText()
        }

        if (!title.isBlank() && !text.isBlank()) {
            val date = Date(System.currentTimeMillis())
            val note = Note(title, text, date)
            NoteRepository.addNote(note)
            uiState.value = UiState.Saved(note)
        }
    }

    sealed class UiState {

        class WrongTitle : UiState()

        class WrongText : UiState()

        class Saved(val note: Note) : UiState()

    }
}