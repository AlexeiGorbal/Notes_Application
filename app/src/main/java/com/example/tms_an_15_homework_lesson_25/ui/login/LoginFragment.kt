package com.example.tms_an_15_homework_lesson_25.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentLoginBinding

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
                    findNavController().navigate(R.id.action_loginFragment_to_bottomNavigationFragment)
                }
            }
        }

        binding.singUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}