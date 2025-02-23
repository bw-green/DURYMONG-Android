package com.example.durymong.view.user.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.durymong.model.TokenManager
import com.example.durymong.model.dto.request.user.ReIssueTokenReq
import com.example.durymong.model.dto.request.user.UserLoginRequestDto
import com.example.durymong.model.repository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = UserRepository()

    fun loginTest() {
        val userData = UserLoginRequestDto(
            id = "durymong",
            password = "durymong12"
        )

        viewModelScope.launch {
            repository.postLogin(userData) { response ->
                if (response != null) {
                    Log.d("AuthViewModel", "로그인 성공: ${response.result.accessToken}")
                    val token = response.result.accessToken
                    val refreshToken = response.result.refreshToken
                    if (token.isNotBlank()) {
                        TokenManager.saveToken(token)
                        TokenManager.saveRefreshToken(refreshToken)
                        Log.d("AuthViewModel", "토큰 저장 성공 : $token")
                    } else{
                        Log.e("AuthViewModel", "토큰 저장 실패")
                    }
                } else {
                    Log.e("AuthViewModel", "로그인 실패")
                }
            }
        }
        fun Refresh(){
            val refreshToken = TokenManager.getToken()
            repository.postRefreshToken(
                ReIssueTokenReq(refreshToken!!),
                responseCallback = {
                    TokenManager.saveToken(it.result.newAccessToken)
                    TokenManager.saveRefreshToken(it.result.newRefreshToken)
                }
            )
        }
    }
}