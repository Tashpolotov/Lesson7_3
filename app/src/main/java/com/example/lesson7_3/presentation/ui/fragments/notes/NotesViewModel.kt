package com.example.lesson7_3.presentation.ui.fragments.notes


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.usecase.DeleteUseCase
import com.example.lesson7_3.domain.usecase.GetAllNotesUseCase
import com.example.lesson7_3.domain.utils.Resource
import com.example.lesson7_3.presentation.base.BaseViewModel
import com.example.lesson7_3.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteUseCase: DeleteUseCase
) :BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNotesState = _deleteNoteState

    fun deleteNote(note: Note) {

      deleteUseCase.deleteNote(note).collectData(_deleteNoteState)
    }
    fun getAllNotes() {
    getAllNotesUseCase.getAllNotes().collectData(_getAllNotesState)
    }
}


