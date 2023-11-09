package com.example.tms_an_15_homework_lesson_25.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentOnboardingBinding
import com.example.tms_an_15_homework_lesson_25.ui.login.LoginFragment

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.viewPager.adapter = OnboardingAdapter(childFragmentManager)
        binding.circleIndicator.setViewPager(binding.viewPager)

        binding.skipButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, LoginFragment.newInstance())
            }
        }
    }

    companion object {

        fun newInstance() = OnboardingFragment()
    }
}