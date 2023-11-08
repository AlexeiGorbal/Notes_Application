package com.example.tms_an_15_homework_lesson_25.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentBottomNavigationBinding
import com.example.tms_an_15_homework_lesson_25.ui.note.create.CreateNoteFragment
import com.example.tms_an_15_homework_lesson_25.ui.note.list.NoteListFragment

class BottomNavigationFragment : Fragment() {

    private var _binding: FragmentBottomNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomNavigationBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        childFragmentManager.setFragmentResultListener(
            CreateNoteFragment.REQUEST_KEY,
            viewLifecycleOwner
        ) { requestKey, result ->
            binding.bottomNavigationView.menu.findItem(R.id.icon_home).isChecked = true

            childFragmentManager.commit {
                replace(
                    R.id.navigation_fragment_container,
                    NoteListFragment.newInstance()
                )
            }
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.icon_home -> {
                    childFragmentManager.commit {
                        replace(
                            R.id.navigation_fragment_container,
                            NoteListFragment.newInstance()
                        )
                    }
                    true
                }

                R.id.icon_message -> {
                    childFragmentManager.commit {
                        replace(
                            R.id.navigation_fragment_container,
                            CreateNoteFragment.newInstance()
                        )
                    }
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = BottomNavigationFragment()
    }
}