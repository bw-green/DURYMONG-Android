package com.example.durymong.model.repository

import com.example.durymong.retrofit.RetrofitObject
import com.example.durymong.retrofit.service.ColumnService

class ColumnRepository {
    // 칼럼 관련 기능을 수행하는 Repository
    // 여기에서 함수를 구현해서 call.enque 와 같은 작업 수행
    private val service: ColumnService = RetrofitObject.createService()

    fun getColumnCategories() = service.getColumnCategories()
}