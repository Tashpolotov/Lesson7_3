package com.example.lesson7_3.data.mapper

import com.example.lesson7_3.data.model.NoteEntity
import com.example.lesson7_3.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id, title, descriptions
)

fun NoteEntity.toNote() = Note(
    id,title,description
)