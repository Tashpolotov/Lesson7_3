package com.example.lesson7_3.domain.usecase


import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.repository.NoteRepository
import javax.inject.Inject

class
DeleteUseCase @Inject constructor
    (private val noteRepository: NoteRepository
) {

    fun deleteNote (note: Note) = noteRepository.delete(note)
}