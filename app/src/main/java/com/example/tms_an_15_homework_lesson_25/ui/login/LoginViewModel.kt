package com.example.tms_an_15_homework_lesson_25.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_an_15_homework_lesson_25.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val uiState = MutableLiveData<UiState>()

    fun searchUser(email: String, password: String) {
        viewModelScope.launch {
            val user = UserRepository.getUser(email, password)
            if (user == null) {
                uiState.value = UiState.UserNotFound()
            } else {
                uiState.value = UiState.UserFound()
            }
        }
    }
}