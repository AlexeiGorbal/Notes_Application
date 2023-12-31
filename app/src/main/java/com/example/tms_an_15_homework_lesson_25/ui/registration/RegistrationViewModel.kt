package com.example.tms_an_15_homework_lesson_25.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_an_15_homework_lesson_25.model.User
import com.example.tms_an_15_homework_lesson_25.repository.UserRepository
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {

    val uiState = MutableLiveData<UiState>()

    fun saveUser(firstName: String, lastName: String, email: String, password: String) {

        if (firstName.isBlank()) {
            uiState.value = UiState.WrongFirstName()
        }

        if (lastName.isBlank()) {
            uiState.value = UiState.WrongLastName()
        }

        if (email.isBlank()) {
            uiState.value = UiState.WrongEmail()
        }

        if (password.isBlank()) {
            uiState.value = UiState.WrongPassword()
        }

        if (!firstName.isBlank() && !lastName.isBlank()
            && !email.isBlank() && !password.isBlank()
        ) {
            viewModelScope.launch {
                UserRepository.addUser(User(firstName, lastName, email, password))
                uiState.value = UiState.Saved()
            }
        }
    }
}