package com.example.tms_an_15_homework_lesson_25.ui.login

import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.model.User
import com.example.tms_an_15_homework_lesson_25.repository.UserRepository
import com.example.tms_an_15_homework_lesson_25.ui.BottomNavigationFragment
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