package com.example.tms_an_15_homework_lesson_25.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.example.tms_an_15_homework_lesson_25.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.uiState.observe(this) {
            if (it is UiState.MainScreen) {
                supportFragmentManager.commit {
                    replace(android.R.id.content, NavHostFragment.create(R.navigation.graph_main))
                }
            } else {
                supportFragmentManager.commit {
                    replace(android.R.id.content, NavHostFragment.create(R.navigation.graph_login))
                }
            }
        }
    }
}