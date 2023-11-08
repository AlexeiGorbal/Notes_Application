package com.example.tms_an_15_homework_lesson_25.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
) : Parcelable