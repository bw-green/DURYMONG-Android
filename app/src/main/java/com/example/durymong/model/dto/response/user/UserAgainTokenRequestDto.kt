package com.example.durymong.model.dto.response.user

data class UserAgainTokenRequestDto(
    val success: Boolean,
    val code: Int,
    val message: String,
    val result: NewToken
)
data class NewToken(
    val newAccessToken: String,
    val newRefreshToken: String
)
