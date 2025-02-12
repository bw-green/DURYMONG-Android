package com.example.durymong.retrofit.service

import com.example.durymong.model.dto.request.user.UserLoginRequestDto
import com.example.durymong.model.dto.response.user.UserTokenRequestDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("users/login")
    fun postLogin(
        @Body userData: UserLoginRequestDto
    ): Call<UserTokenRequestDto>
}