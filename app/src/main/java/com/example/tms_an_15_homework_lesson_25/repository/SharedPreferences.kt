package com.example.tms_an_15_homework_lesson_25.repository

import android.content.Context
import androidx.core.content.edit

private const val SHARED_PREFERENCES = "shared_preferences"
private const val IS_OPEN = "is_open"

class SharedPreferences(context: Context) {

    private val preferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    fun appIsOpen(): Boolean {
        return preferences.getBoolean(IS_OPEN, false)
    }

    fun setIsOpen() {
        preferences.edit {
            putBoolean(IS_OPEN, true)
        }
    }
}