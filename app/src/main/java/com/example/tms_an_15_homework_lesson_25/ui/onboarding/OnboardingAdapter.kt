package com.example.tms_an_15_homework_lesson_25.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class OnboardingAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val list =
        mutableListOf(
            OnboardingStepFragment.getFragment(OnboardingStepFragment.ONBOARDING_1),
            OnboardingStepFragment.getFragment(OnboardingStepFragment.ONBOARDING_2),
            OnboardingStepFragment.getFragment(OnboardingStepFragment.ONBOARDING_3)
        )

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }
}