package com.example.tms_an_15_homework_lesson_25.ui.note.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_an_15_homework_lesson_25.model.Note
import com.example.tms_an_15_homework_lesson_25.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

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
            viewModelScope.launch { repository.addNote(note) }
            uiState.value = UiState.Saved(note)
        }
    }
}