package com.example.tms_an_15_homework_lesson_25.ui.registration

sealed class UiState {

    class WrongFirstName : UiState()

    class WrongLastName : UiState()

    class WrongEmail : UiState()

    class WrongPassword : UiState()

    class Saved : UiState()

}