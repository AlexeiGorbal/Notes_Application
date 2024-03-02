package com.example.tms_an_15_homework_lesson_25.ui.note.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tms_an_15_homework_lesson_25.model.Note
import com.example.tms_an_15_homework_lesson_25.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val notes: LiveData<List<Note>>
        get() = repository.getNotes()
}