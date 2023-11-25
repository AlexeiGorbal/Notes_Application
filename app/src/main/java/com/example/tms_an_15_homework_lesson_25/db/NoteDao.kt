package com.example.tms_an_15_homework_lesson_25.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Query("SELECT * FROM Note")
    suspend fun getNotes(): List<NoteEntity>
}