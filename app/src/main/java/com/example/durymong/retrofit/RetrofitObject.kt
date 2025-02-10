package com.example.durymong.retrofit

import com.example.durymong.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = BuildConfig.BASE_URL

    val retrofit: Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    // Repository에서 서비스를 생성할 때 사용
    // ex) private val service: SampleService = RetrofitObject.createService()
    inline fun <reified T> createService(): T = retrofit.create(T::class.java)
}