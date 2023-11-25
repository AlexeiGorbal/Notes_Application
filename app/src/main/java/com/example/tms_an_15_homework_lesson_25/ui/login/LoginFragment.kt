package com.example.tms_an_15_homework_lesson_25.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentLoginBinding
import com.example.tms_an_15_homework_lesson_25.repository.UserRepository
import com.example.tms_an_15_homework_lesson_25.ui.BottomNavigationFragment
import com.example.tms_an_15_homework_lesson_25.ui.registration.RegistrationFragment

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.button.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            viewModel.searchUser(email, password)
        }

        viewModel.uiState.observe(viewLifecycleOwner) {

            when (it) {
                is UiState.UserNotFound ->
                    Toast.makeText(context, R.string.user_not_found, Toast.LENGTH_SHORT).show()

                is UiState.UserFound -> {
                    parentFragmentManager.commit {
                        replace(R.id.fragment_container, BottomNavigationFragment.newInstance())
                    }
                }
            }
        }

        binding.singUpButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RegistrationFragment.newInstance())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = LoginFragment()
    }
}