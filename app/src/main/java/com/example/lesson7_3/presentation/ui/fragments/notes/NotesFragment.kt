package com.example.lesson7_3.presentation.ui.fragments.notes

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson7_3.R
import com.example.lesson7_3.databinding.FragmentNotesBinding
import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.presentation.base.BaseFragment
import com.example.lesson7_3.presentation.ui.fragments.notes.adapter.AdapterNotes
import com.example.lesson7_3.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : BaseFragment(R.layout.fragment_notes) {

    private val viewModel: NotesViewModel by viewModels()
    private val binding by viewBinding(FragmentNotesBinding::bind)
    private val adapter by lazy { AdapterNotes(this::onClick, this::onLongClick) }
    private var title = ""



    override fun initialize() {
        binding.rvNotesFragment.adapter = adapter
    }

    override fun setupRequests() {
        viewModel.getAllNotes()

    }

    override fun setupSubscribers() {
        viewModel.getAllNotesState.collectUIState(
            state = {
                    binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                adapter.submitList(it)

            }

        )

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.deleteNotesState.collect{ state ->
                    when(state) {
                        is UIState.Loading ->  {}
                        is UIState.Success -> {
                            Toast.makeText(requireContext(), title + "has delete", Toast.LENGTH_SHORT).show()
                            setupRequests()
                        }
                        else -> {}
                    }
                }
            }
        }

    }

    override fun setupListeners() {
        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.addNotesFragment)
        }
    }

    private fun onClick(note: Note) {
        findNavController().navigate(R.id.addNotesFragment, bundleOf(EDIT to note))
    }

    private fun onLongClick(note: Note) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder) {
            setTitle(getString(R.string.yesOrNo))
            setPositiveButton(getString(R.string.Yes)) { _, _ ->
                viewModel.deleteNote(note)
                title = note.title

            }
            setNegativeButton(getString(R.string.No)) { a1, _ ->
                a1.dismiss()
            }
        }.show()
    }

    companion object{
        const val EDIT = "note"
    }
}

