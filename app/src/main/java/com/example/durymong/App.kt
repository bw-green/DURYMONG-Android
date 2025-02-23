package com.example.durymong

import android.app.Application
import com.example.durymong.model.RetryInterceptor
import com.example.durymong.model.TokenManager


class  App : Application(){
//    lateinit var apiService: ApiService
    override fun onCreate() {
        super.onCreate()
        TokenManager.init(this)

//        val userRepository = UserRepository() // ✅ UserRepository 먼저 생성
//        val retryInterceptor = RetryInterceptor(userRepository) // ✅ RetryInterceptor 생성
//
//        val client = RetrofitObject.createClient(retryInterceptor) // ✅ Retrofit 생성 전에 주입
//        RetrofitObject.createRetrofit(client)
//
//        apiService = RetrofitObject.createService2() .create(ApiService::class.java) // ✅ API 인터페이스 생성

    }
}