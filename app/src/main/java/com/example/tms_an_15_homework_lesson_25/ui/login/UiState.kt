package com.example.tms_an_15_homework_lesson_25.ui.login

sealed class UiState {

    class UserNotFound : UiState()

    class UserFound : UiState()

}