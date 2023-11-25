package com.example.tms_an_15_homework_lesson_25.repository

import com.example.tms_an_15_homework_lesson_25.db.NoteDao
import com.example.tms_an_15_homework_lesson_25.db.NoteEntity
import com.example.tms_an_15_homework_lesson_25.model.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(
    private var noteDao: NoteDao
) {

    suspend fun addNote(note: Note) {
        val entity = note.toEntity()
        noteDao.addNote(entity)
    }

    suspend fun getNotes(): List<Note> {
        return noteDao.getNotes().map {
            it.toModel()
        }
    }
}

private fun Note.toEntity(): NoteEntity {
    return NoteEntity(null, title, text, date)
}

private fun NoteEntity.toModel(): Note {
    return Note(title = title, text = text, date = date)
}