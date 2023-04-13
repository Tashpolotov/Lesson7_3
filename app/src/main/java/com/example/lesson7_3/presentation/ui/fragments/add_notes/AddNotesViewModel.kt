package com.example.lesson7_3.presentation.ui.fragments.add_notes

import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.usecase.CreateNoteUseCase
import com.example.lesson7_3.domain.usecase.EditNoteUseCase
import com.example.lesson7_3.presentation.base.BaseViewModel
import com.example.lesson7_3.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
): BaseViewModel() {

    private val _addNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val addNotesState = _addNotesState.asStateFlow()

    private val _editeNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editeNotesState = _editeNotesState.asStateFlow()

    fun createNote(note: Note) {
        createNoteUseCase.createNote(note).collectData(_addNotesState)
    }

    fun editNote(note: Note) {
        editNoteUseCase.getAllNotes(note).collectData(_editeNotesState)
    }
}