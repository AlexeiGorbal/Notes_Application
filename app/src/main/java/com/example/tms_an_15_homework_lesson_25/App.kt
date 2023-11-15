package com.example.tms_an_15_homework_lesson_25

import android.app.Application
import com.example.tms_an_15_homework_lesson_25.db.DataBase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DataBase.createDataBase(applicationContext)
    }
}