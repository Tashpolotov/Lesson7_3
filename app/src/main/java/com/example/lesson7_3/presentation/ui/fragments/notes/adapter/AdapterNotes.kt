package com.example.lesson7_3.presentation.ui.fragments.notes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson7_3.databinding.ItemListBinding
import com.example.lesson7_3.domain.model.Note

class AdapterNotes(private var onClick: (Note) -> Unit,
                   private var onLongClick: (Note) -> Unit
): ListAdapter<Note, AdapterNotes.Holder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    inner class Holder(
        private val binding: ItemListBinding
        ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.tvTitle.text = note.descriptions
            binding.tvDesc.text = note.title


            itemView.setOnClickListener {
                onClick(note)

            }
            itemView.setOnLongClickListener {
                onLongClick(note)
                return@setOnLongClickListener true
            }
        }
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }


    @SuppressLint("DiffUtilEquals")
    class Comparator: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }

}