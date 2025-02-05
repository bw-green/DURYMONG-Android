package com.example.durymong.view.do_it.stress_test_page.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestPageViewModel : ViewModel() {

    private val _testPageList = MutableLiveData<List<TestPageData>>()

    val testPageList: LiveData<List<TestPageData>> get() = _testPageList


    init {
        fetchTestPageData()
    }

    private fun fetchTestPageData() {
        //api 연결해야함
        _testPageList.value = listOf(
            TestPageData(
                4,
                "1. 쉽게 짜증이 나고 기분의 변동이 심하다."
            ),
            TestPageData(
                3,
                "2. 피부가 거칠고 각종 피부 질환이 심해졌다."
            ),
            TestPageData(
                3,
                "3. 온몸의 근육이 긴장되고 여기저기 쑤신다."
            ),
            TestPageData(
                4,
                "4. 수면 장애를 겪는다."
            ),
            TestPageData(
                3,
                "5. 매사에 자신이 없고 자기 비하를 많이 한다."
            ),
            TestPageData(
                3,
                "6. 별다른 이유 없이 불안 초조하다."
            ),
            TestPageData(
                3,
                "7. 쉽게 피로감을 느낀다."
            ),
            TestPageData(
                3,
                "8. 매사에 집중이 잘 안되고 일이나 학습 능률이 떨어진다."
            )
        )
    }
}