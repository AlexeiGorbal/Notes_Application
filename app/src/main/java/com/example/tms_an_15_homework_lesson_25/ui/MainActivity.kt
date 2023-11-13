package com.example.tms_an_15_homework_lesson_25.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.ui.login.LoginFragment
import com.example.tms_an_15_homework_lesson_25.ui.onboarding.OnboardingFragment

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.uiState.observe(this) {
            if (it is MainViewModel.UiState.MainScreen) {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, MainFragment.newInstance())
                }
            } else {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, LoginFragment.newInstance())
                }
            }
        }
    }
}