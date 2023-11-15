package com.example.tms_an_15_homework_lesson_25.repository

import com.example.tms_an_15_homework_lesson_25.db.DataBase
import com.example.tms_an_15_homework_lesson_25.db.NoteEntity
import com.example.tms_an_15_homework_lesson_25.model.Note

object NoteRepository {

    fun addNote(note: Note) {
        val entity = NoteEntity(null, note.title, note.text, note.date)
        DataBase.noteDao?.addNote(entity)
    }

    fun getNotes(): List<Note> {
        return DataBase.noteDao?.getNotes()?.map {
            Note(title = it.title, text = it.text, date = it.date)
        } ?: emptyList()
    }
}