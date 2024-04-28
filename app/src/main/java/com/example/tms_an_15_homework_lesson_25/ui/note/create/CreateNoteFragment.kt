package com.example.tms_an_15_homework_lesson_25.ui.note.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentCreateNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : Fragment() {

    private var _binding: FragmentCreateNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CreateNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.button.setOnClickListener {

            val title = binding.title.text.toString()
            val text = binding.message.text.toString()
            viewModel.saveNote(title, text)
        }

        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.WrongTitle ->
                    binding.title.error = EMPTY_TITLE

                is UiState.WrongText ->
                    binding.message.error = EMPTY_TEXT

                is UiState.Saved -> {
                    findNavController().navigateUp()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val EMPTY_TITLE = "Empty title"
        private const val EMPTY_TEXT = "Empty message"
    }
}