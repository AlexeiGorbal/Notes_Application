package com.example.tms_an_15_homework_lesson_25.repository

import com.example.tms_an_15_homework_lesson_25.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.withContext

object UserRepository {

    private val list = mutableListOf<User>(
        User("q", "q", "q", "q")
    )

    suspend fun addUser(user: User) {
        withContext(Dispatchers.Default) {
            ensureActive()
            list.add(user)
        }
    }

    suspend fun getUser(email: String, password: String): User? {
        return withContext(Dispatchers.Default) {
            list.find {
                it.email == email && it.password == password
            }
        }
    }
}