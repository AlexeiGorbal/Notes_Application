package com.example.tms_an_15_homework_lesson_25.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentOnbourdingStepBinding

class OnboardingStepFragment : Fragment() {

    private var _binding: FragmentOnbourdingStepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnbourdingStepBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.getInt(KAY_ONBOARDING).run {

            when (this) {
                ONBOARDING_1 -> {
                    binding.image.setImageResource(R.drawable.money)
                    binding.text.setText(R.string.onboarding_1)
                }

                ONBOARDING_2 -> {
                    binding.image.setImageResource(R.drawable.level_up)
                    binding.text.setText(R.string.onboarding_2)
                }

                ONBOARDING_3 -> {
                    binding.image.setImageResource(R.drawable.chat)
                    binding.text.setText(R.string.onboarding_3)
                }
            }
        }
    }


    companion object {

        private const val KAY_ONBOARDING = "step"
        const val ONBOARDING_1 = 1
        const val ONBOARDING_2 = 2
        const val ONBOARDING_3 = 3

        fun getFragment(step: Int): Fragment {
            return OnboardingStepFragment().apply {
                arguments = bundleOf(KAY_ONBOARDING to step)
            }
        }
    }
}