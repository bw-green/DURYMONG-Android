package com.example.durymong.model.repository

import android.util.Log
import com.example.durymong.model.dto.request.user.ReIssueTokenReq
import com.example.durymong.model.dto.request.user.UserLoginRequestDto
import com.example.durymong.model.dto.response.user.UserAgainTokenRequestDto
import com.example.durymong.model.dto.response.user.UserTokenRequestDto
import com.example.durymong.retrofit.RetrofitObject
import com.example.durymong.retrofit.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    // 로그인, 회원가입과 같이 user 관련된 기능 수행하는 Repository
    // 여기에서 함수를 구현해서 call.enque 와 같은 작업 수행
    private val service: UserService = RetrofitObject.createService()

    fun postLogin(userData: UserLoginRequestDto, callback: (UserTokenRequestDto?) -> Unit) {
        service.postLogin(userData).enqueue(object : Callback<UserTokenRequestDto> {
            override fun onResponse(
                call: Call<UserTokenRequestDto>,
                response: Response<UserTokenRequestDto>
            ) {
                if (response.isSuccessful) {
                    Log.d("successful", "로그인 성공")
                    callback(response.body())
                } else {
                    Log.e("UserRepository", "로그인 실패: ${response.errorBody()?.string()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<UserTokenRequestDto>, t: Throwable) {
                Log.e("UserRepository", "Network error: ${t.message}")
            }
        })
    }

    fun postRefreshToken(token: ReIssueTokenReq, responseCallback: (UserAgainTokenRequestDto) -> Unit) {
        service.refreshToken(token).enqueue(object : Callback<UserAgainTokenRequestDto>{
            override fun onResponse(
                p0: Call<UserAgainTokenRequestDto>,
                p1: Response<UserAgainTokenRequestDto>
            ) {
                if(p1.isSuccessful){
                    if(p1.body()!=null) {
                        responseCallback(p1.body()!!)
                    }
                    Log.d("postRefreshToken", "성공")
                }
            }

            override fun onFailure(p0: Call<UserAgainTokenRequestDto>, p1: Throwable) {
                Log.d("postRefreshToken", "Network error: ${p1.message}")
            }

        })
    }

}