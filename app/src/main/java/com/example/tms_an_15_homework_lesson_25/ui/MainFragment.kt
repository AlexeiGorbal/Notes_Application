package com.example.tms_an_15_homework_lesson_25.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentMainBinding
import com.example.tms_an_15_homework_lesson_25.ui.login.LoginFragment
import com.example.tms_an_15_homework_lesson_25.ui.onboarding.OnboardingFragment

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            childFragmentManager.commit {
                replace(R.id.fragment_container, OnboardingFragment.newInstance())
            }
        }

        binding.loginButton.setOnClickListener {
            childFragmentManager.commit {
                replace(R.id.fragment_container, LoginFragment.newInstance())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}