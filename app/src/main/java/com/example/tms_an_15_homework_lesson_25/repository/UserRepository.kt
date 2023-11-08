package com.example.tms_an_15_homework_lesson_25.repository

import com.example.tms_an_15_homework_lesson_25.model.User

object UserRepository {

    private val list = mutableListOf<User>(
        User("q", "q", "q", "q")
    )

    fun addUser(user: User) {
        list.add(user)
    }

    fun getUser(email: String, password: String): User? {
        return list.find {
            it.email == email && it.password == password
        }
    }
}