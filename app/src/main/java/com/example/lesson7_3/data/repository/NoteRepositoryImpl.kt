package com.example.lesson7_3.data.repository

import com.example.lesson7_3.data.base.BaseRepository
import com.example.lesson7_3.data.mapper.toEntity
import com.example.lesson7_3.data.mapper.toNote
import com.example.lesson7_3.data.model.NoteDao
import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
):  NoteRepository, BaseRepository() {
    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes()= doRequest {
    noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note)= doRequest {
        noteDao.editNote(note.toEntity())
    }

    override fun delete(note: Note)= doRequest {
        noteDao.deleteNote(note.toEntity())

    }


}