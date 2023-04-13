package com.example.lesson7_3.domain.usecase


import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor
    (private val noteRepository: NoteRepository
) {

    fun createNote (note: Note) = noteRepository.createNote(note)
}