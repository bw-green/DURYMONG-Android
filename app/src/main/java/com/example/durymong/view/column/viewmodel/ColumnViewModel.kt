package com.example.durymong.view.column.viewmodel

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.durymong.R
import kotlinx.parcelize.Parcelize


class ColumnViewModel : ViewModel() {
    //실제 data를 저장할 변수들
    private val _columnCategoryList = MutableLiveData<List<ColumnCategory>>()
    private val _columnData = MutableLiveData<Column>()

    //화면에서 아래 변수들을 통해 값에 접근
    val columnCategoryList: LiveData<List<ColumnCategory>> get() = _columnCategoryList
    val columnData: LiveData<Column> get() = _columnData

    init {
        //처음 viewModel이 생성될 때 실행할 작업들
        fetchColumnCategoryData()
    }

    //데이터를 가져오는 함수, api 연결시에 변경 예정, 현재는 테스트용 코드
    fun fetchColumnCategoryData() {
        _columnCategoryList.value = listOf(
            ColumnCategory(
                imgId = R.drawable.ic_column_sleep_disorder,
                name = "#수면장애",
                description = "수면장애란 제대로 잘 수 없는~"
            ),
            ColumnCategory(
                imgId = R.drawable.ic_column_sleep_disorder,
                name = "#우울감",
                description = "우울감이란~"
            ),
            ColumnCategory(
                imgId = R.drawable.ic_column_sleep_disorder,
                name = "#공황장애",
                description = "공황장애란~"
            ),
        )
    }

    //데이터를 가져오는 함수, api 연결시에 변경 예정, 현재는 테스트용 코드
    fun fetchColumnData() {
        _columnData.value = Column(
            imgId= R.drawable.img_column_thumbnail_dummy,
            headLine = "잠 못 드는 하루하루, 수면장애",
            title = "수면장애에 대한 이야기",
            body = "본문 내용.."
        )
    }

    data class ColumnCategory(
        val imgId: Int,
        val name: String,
        val description: String
    )

    @Parcelize
    data class Column(
        val imgId: Int,
        val headLine: String,
        val title: String,
        val body: String
    ): Parcelable
}