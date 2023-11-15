package com.example.tms_an_15_homework_lesson_25.ui.note.create

import com.example.tms_an_15_homework_lesson_25.model.Note

sealed class UiState {

    class WrongTitle : UiState()

    class WrongText : UiState()

    class Saved(val note: Note) : UiState()

}