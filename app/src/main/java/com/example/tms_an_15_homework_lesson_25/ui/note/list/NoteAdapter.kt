package com.example.tms_an_15_homework_lesson_25.ui.note.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_25.model.Note

class NoteAdapter(private val onItemClick: (Note) -> Unit) :
    RecyclerView.Adapter<NoteViewHolder>() {

    private val list = mutableListOf<Note>()

    fun setNotes(list: List<Note>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position], onItemClick)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

