package com.example.tms_an_15_homework_lesson_25.repository

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val SHARED_PREFERENCES = "shared_preferences"
private const val IS_OPEN = "is_open"

@Singleton
class SharedPreferences @Inject constructor(@ApplicationContext private val context: Context) {

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