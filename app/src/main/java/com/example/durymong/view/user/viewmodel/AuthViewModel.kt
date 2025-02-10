package com.example.durymong.view.user.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.durymong.model.dto.request.user.UserLoginRequestDto
import com.example.durymong.model.repository.UserRepository

class AuthViewModel : ViewModel() {
    private val repository = UserRepository()

    fun loginTest() {
        val userData = UserLoginRequestDto(
            id = "durymong",
            password = "durymong12"
        )

        repository.postLogin(userData) { response ->
            if (response != null) {
                Log.d("AuthViewModel", "로그인 성공: ${response.result.accessToken}")
            } else {
                Log.e("AuthViewModel", "로그인 실패")
            }
        }

    }
}