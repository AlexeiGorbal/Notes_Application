package com.example.tms_an_15_homework_lesson_25.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentRegistrationBinding
import com.example.tms_an_15_homework_lesson_25.model.User
import com.example.tms_an_15_homework_lesson_25.repository.UserRepository
import com.example.tms_an_15_homework_lesson_25.ui.login.LoginFragment

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.button.setOnClickListener {

            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            viewModel.SaveUser(firstName, lastName, email, password)
        }

        viewModel.uiState.observe(viewLifecycleOwner) {

            when (it) {
                is RegistrationViewModel.UiState.WrongFirstName ->
                    binding.firstName.error = EMPTY_FIRST_NAME

                is RegistrationViewModel.UiState.WrongLastName ->
                    binding.lastName.error = EMPTY_LAST_NAME

                is RegistrationViewModel.UiState.WrongEmail ->
                    binding.email.error = EMPTY_EMAIL

                is RegistrationViewModel.UiState.WrongPassword ->
                    binding.password.error = EMPTY_PASSWORD

                is RegistrationViewModel.UiState.Saved -> {
                    Toast.makeText(context, R.string.user_created, Toast.LENGTH_SHORT).show()

                    parentFragmentManager.commit {
                        replace(R.id.fragment_container, LoginFragment.newInstance())
                    }
                }
            }
        }

        binding.loginButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, LoginFragment.newInstance())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = RegistrationFragment()

        private const val EMPTY_FIRST_NAME = "Empty first name"
        private const val EMPTY_LAST_NAME = "Empty last name"
        private const val EMPTY_EMAIL = "Empty email"
        private const val EMPTY_PASSWORD = "Empty password"
    }
}