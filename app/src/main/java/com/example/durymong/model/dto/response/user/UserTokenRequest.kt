package com.example.durymong.model.dto.response.user

data class UserTokenRequest(
    var success: Boolean,
    var code: Int,
    var message: String,
    var result: Token
)

data class Token(
    var accessToken: String,
    var refreshToken: String
)
