package com.example.tms_an_15_homework_lesson_25.repository

import com.example.tms_an_15_homework_lesson_25.model.Note

object NoteRepository {

    private val list = mutableListOf<Note>()

    fun addNote(note: Note) {
        list.add(note)
    }

    fun getNotes(): List<Note> {
        return list
    }
}