package com.example.tms_an_15_homework_lesson_25.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tms_an_15_homework_lesson_25.util.Converters

@TypeConverters(Converters::class)
@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
}