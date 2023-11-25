package com.example.tms_an_15_homework_lesson_25.di

import android.content.Context
import androidx.room.Room
import com.example.tms_an_15_homework_lesson_25.db.AppDataBase
import com.example.tms_an_15_homework_lesson_25.db.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val CREATE_DATA_BASE = "createDataBase"

@Module
@InstallIn(SingletonComponent::class)
class AppModel {

    @Provides
    @Singleton
    fun provideNoteDao(@ApplicationContext context: Context): NoteDao {
        return Room.databaseBuilder(context, AppDataBase::class.java, CREATE_DATA_BASE).build()
            .getNoteDao()
    }
}