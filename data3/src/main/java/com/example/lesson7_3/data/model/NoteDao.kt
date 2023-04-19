package com.example.lesson7_3.data.model

import androidx.room.*

@Dao
interface NoteDao {

        //CRUD
        //C - create
        //R - read
        //U - update
        //D - delete

        @Insert
        suspend fun createNote(noteEntity: NoteEntity)

        @Query("SELECT * FROM notes")
        suspend fun getAllNotes(): List<NoteEntity>

        @Update
        suspend fun editNote(noteEntity: NoteEntity)

        @Delete
        suspend fun deleteNote(noteEntity: NoteEntity)



}