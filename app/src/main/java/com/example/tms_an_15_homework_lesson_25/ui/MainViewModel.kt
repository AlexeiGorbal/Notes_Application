package com.example.tms_an_15_homework_lesson_25.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_an_15_homework_lesson_25.repository.SharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(sharedPreferences: SharedPreferences) :
    ViewModel() {

    val uiState = MutableLiveData<UiState>()

    init {

        if (sharedPreferences.appIsOpen()) {
            uiState.value = UiState.LoginScreen()
        } else {
            uiState.value = UiState.MainScreen()
            sharedPreferences.setIsOpen()
        }
    }
}