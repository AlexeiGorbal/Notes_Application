package com.example.tms_an_15_homework_lesson_25.ui.note.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_an_15_homework_lesson_25.model.Note
import com.example.tms_an_15_homework_lesson_25.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel : ViewModel() {

    val notes = MutableLiveData<List<Note>>()

    init {
        viewModelScope.launch {
            notes.value = NoteRepository.getNotes()
        }
    }
}