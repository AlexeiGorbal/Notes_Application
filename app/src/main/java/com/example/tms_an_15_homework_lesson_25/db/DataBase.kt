package com.example.tms_an_15_homework_lesson_25.db

import android.content.Context
import androidx.room.Room

private const val CREATE_DATA_BASE = "createDataBase"

object DataBase {

    var noteDao: NoteDao? = null

    fun createDataBase(context: Context) {
        val dataBase: AppDataBase =
            Room.databaseBuilder(context, AppDataBase::class.java, CREATE_DATA_BASE).build()
        noteDao = dataBase.getNoteDao()
    }
}