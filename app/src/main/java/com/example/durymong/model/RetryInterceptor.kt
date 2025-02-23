package com.example.durymong.model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.durymong.model.repository.UserRepository
import com.example.durymong.retrofit.RetrofitObject
import com.example.durymong.retrofit.service.UserService
import com.example.durymong.view.user.viewmodel.AuthViewModel
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class RetryInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var response = chain.proceed(request)


        // 응답 바디를 문자열로 변환
        val responseBodyString = response.body?.string() ?: ""

        // 특정 코드가 응답에 포함되면 추가 요청 실행
        if (responseBodyString.contains("-203")) {
            // 추가 요청 생성 (예: 인증 토큰 갱신)
            Log.d("RetryInterceptor", "retrying request")
            TokenManager.clearToken()
        }

        // 원래 응답을 다시 생성 (body를 재사용할 수 있도록 새로 만듦)
        return response.newBuilder()
            .body(responseBodyString.toResponseBody(response.body?.contentType()))
            .build()
    }
}
