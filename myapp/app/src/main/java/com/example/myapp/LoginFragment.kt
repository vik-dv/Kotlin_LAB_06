package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.tilUsername.error = "Введите имя пользователя"
                return@setOnClickListener
            } else {
                binding.tilUsername.error = null
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Введите пароль"
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            // Здесь ваша логика авторизации
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}