package com.example.tms_an_15_homework_lesson_25.repository

import com.example.tms_an_15_homework_lesson_25.db.DataBase
import com.example.tms_an_15_homework_lesson_25.db.NoteEntity
import com.example.tms_an_15_homework_lesson_25.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object NoteRepository {

    suspend fun addNote(note: Note) {
        val entity = note.toEntity()
        DataBase.noteDao?.addNote(entity)
    }

    suspend fun getNotes(): List<Note> {
        return DataBase.noteDao?.getNotes()?.map {
           it.toModel()
        } ?: emptyList()
    }
}

private fun Note.toEntity(): NoteEntity {
    return NoteEntity(null, title, text, date)
}

private fun NoteEntity.toModel(): Note {
    return Note(title = title, text = text, date = date)
}