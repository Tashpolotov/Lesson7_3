package com.example.lesson7_3.presentation.ui.fragments.add_notes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson7_3.R
import com.example.lesson7_3.databinding.FragmentAddNotesBinding
import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.presentation.base.BaseFragment
import com.example.lesson7_3.presentation.ui.fragments.notes.NotesFragment.Companion.EDIT
import com.example.lesson7_3.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddNotesFragment : BaseFragment(R.layout.fragment_add_notes) {

    private val viewModel: AddNotesViewModel by viewModels()
    private val binding by viewBinding(FragmentAddNotesBinding::bind)
    private var note: Note? = null
    private var noteIsNull = true


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubscribers()
        initialize()
        initRequests()
    }


    private fun initRequests() {
        saveAdd()
    }

    override fun initSubscribers() {
        collectAdd()
        collectEditNote()
    }

    private fun saveAdd() = with(binding) {
        btnSave.setOnClickListener {
            if (binding.etTitle.text!!.isNotEmpty() && binding.etDesc.text!!.isNotEmpty()) {
                note?.title = etTitle.text.toString()
                note?.descriptions = etDesc.text.toString()
                if (noteIsNull) {
                    viewModel.createNote(note!!)
                } else {
                    viewModel.editNote(note!!)
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Поля не должны быть пустыми",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getNote() {
        if (arguments?.getSerializable(EDIT) == null) {
            note = Note()
        } else {
            note = arguments?.getSerializable(EDIT) as Note
            binding.etTitle.setText(note!!.title)
            binding.etDesc.setText(note!!.descriptions)
            binding.btnSave.text = "Edit"
            noteIsNull = false
        }
    }



    private fun collectAdd(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.addNotesState.collect{
                    when (it) {
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            findNavController().navigateUp()
                        }
                        else -> {}
                    }
                }
            }
        }

    }

    override fun initialize() {
        getNote()
    }

    private fun collectEditNote() {

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.editeNotesState.collect { state ->
                    when (state) {
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            findNavController().navigateUp()
                        }
                        else -> {}
                    }
                }
            }
        }
    }

}