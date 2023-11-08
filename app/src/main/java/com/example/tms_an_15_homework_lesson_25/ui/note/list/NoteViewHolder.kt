package com.example.tms_an_15_homework_lesson_25.ui.note.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.ItemNoteBinding
import com.example.tms_an_15_homework_lesson_25.model.Note
import java.text.SimpleDateFormat

class NoteViewHolder(view: View) : ViewHolder(view) {
    private val binding: ItemNoteBinding = ItemNoteBinding.bind(view)

    private val formatter = SimpleDateFormat("hh:mm MM.dd.yyyy")

    fun bind(note: Note, onItemClick: (Note) -> Unit) {
        binding.title.text = note.title
        binding.text.text = note.text
        binding.date.text = formatter.format(note.date)
        itemView.setOnClickListener {
            onItemClick(note)
        }
    }

    companion object {

        fun from(parent: ViewGroup): NoteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_note,
                parent, false
            )
            return NoteViewHolder(view)
        }
    }
}