package com.example.durymong.view.column.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColumnViewModel: ViewModel() {
    private val _columnList = MutableLiveData<List<Column>>()
    //화면에서 columnList를 통해 값에 접근
    val columnList: LiveData<List<Column>> get() = _columnList

    init {
        //처음 viewModel이 생성될 때 실행할 작업들
        fetchData()
    }

    //데이터를 가져오는 함수, api 연결시에 변경 예정, 현재는 테스트용 코드
    fun fetchData() {
        _columnList.value = listOf(
            Column(
                imgUrl = "asd",
                headLine = "asdfaf",
                title = "asdfasf",
                body = "asdfad"
            )
        )
    }
}

data class Column(
    val imgUrl: String,
    val headLine: String,
    val title: String,
    val body: String
)