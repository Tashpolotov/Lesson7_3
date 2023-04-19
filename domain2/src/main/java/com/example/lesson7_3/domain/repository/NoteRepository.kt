package com.example.lesson7_3.domain.repository

import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun delete(note: Note): Flow<Resource<Unit>>
}