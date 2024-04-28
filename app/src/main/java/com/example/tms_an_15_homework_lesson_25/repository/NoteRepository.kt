package com.example.tms_an_15_homework_lesson_25.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
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

    fun getNotes(): LiveData<List<Note>> {
        return noteDao.getNotes()
            .map { notes ->
                notes.asSequence()
                    .map { it.toModel() }
                    .sortedByDescending { it.date }
                    .toList()
            }
    }
}

private fun Note.toEntity(): NoteEntity {
    return NoteEntity(null, title, text, date)
}

private fun NoteEntity.toModel(): Note {
    return Note(title = title, text = text, date = date)
}