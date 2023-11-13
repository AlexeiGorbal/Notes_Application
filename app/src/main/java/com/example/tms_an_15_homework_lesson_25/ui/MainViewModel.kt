package com.example.tms_an_15_homework_lesson_25.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.tms_an_15_homework_lesson_25.repository.SharedPreferences

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val uiState = MutableLiveData<UiState>()

    private val sharedPreferences = SharedPreferences(application.applicationContext)

    init {

        if (sharedPreferences.appIsOpen()) {
            uiState.value = UiState.LoginScreen()
        } else {
            uiState.value = UiState.MainScreen()
            sharedPreferences.setIsOpen()
        }
    }

    abstract class UiState {

        class MainScreen : UiState()

        class LoginScreen : UiState()
    }
}