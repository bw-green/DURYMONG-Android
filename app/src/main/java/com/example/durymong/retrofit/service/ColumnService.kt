package com.example.durymong.retrofit.service

import com.example.durymong.model.dto.response.column.CategoryResponseDto
import retrofit2.Call
import retrofit2.http.GET

interface ColumnService {
    @GET("column")
    fun getColumnCategories(): Call<CategoryResponseDto>
}