package com.example.tms_an_15_homework_lesson_25.ui.note.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_an_15_homework_lesson_25.model.Note
import com.example.tms_an_15_homework_lesson_25.repository.NoteRepository

class NoteListViewModel : ViewModel() {

    val notes = MutableLiveData<List<Note>>()

    init {
        notes.value = NoteRepository.getNotes()
    }
}