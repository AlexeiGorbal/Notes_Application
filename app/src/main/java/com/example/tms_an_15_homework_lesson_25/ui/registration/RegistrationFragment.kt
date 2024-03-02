package com.example.tms_an_15_homework_lesson_25.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tms_an_15_homework_lesson_25.R
import com.example.tms_an_15_homework_lesson_25.databinding.FragmentRegistrationBinding

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

            viewModel.saveUser(firstName, lastName, email, password)
        }

        viewModel.uiState.observe(viewLifecycleOwner) {

            when (it) {
                is UiState.WrongFirstName ->
                    binding.firstName.error = resources.getString(R.string.empty_first_name)

                is UiState.WrongLastName ->
                    binding.lastName.error = resources.getString(R.string.empty_last_name)

                is UiState.WrongEmail ->
                    binding.email.error = resources.getString(R.string.empty_email)

                is UiState.WrongPassword ->
                    binding.password.error = resources.getString(R.string.empty_password)

                is UiState.Saved -> {
                    Toast.makeText(context, R.string.user_created, Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
                }
            }
        }

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}