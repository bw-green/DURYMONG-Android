package com.example.durymong.view.do_it.test_page.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.durymong.model.dto.request.doit.SubmitTestRequestDto
import com.example.durymong.model.dto.response.doit.QuestionDto
import com.example.durymong.model.dto.response.doit.SubmitTestResponseDto
import com.example.durymong.model.dto.response.doit.TestPageResponseDto
import com.example.durymong.model.repository.DoItRepository
import kotlinx.coroutines.launch

class TestPageViewModel : ViewModel() {

    private var _testPageResponseData = MutableLiveData<TestPageResponseDto>()
    private var _testResult = MutableLiveData<SubmitTestResponseDto>()
    private var _testPageList = MutableLiveData<List<TestPageData>>()


    val testPageList: LiveData<List<TestPageData>> get() = _testPageList
    private val testPageResponseData: LiveData<TestPageResponseDto> get() = _testPageResponseData
    val testResult: MutableLiveData<SubmitTestResponseDto> get() = _testResult

    // 각 테스트 항목

     fun loadTestPageData(testId: Int) {
//         setTestPageData(1) // api 연결 안될 시 더미 코드
        viewModelScope.launch{
            try {
                DoItRepository().getTestData(
                    testId = testId,
                    onSuccess = { dto ->
                        // 여기서 받은 dto를 LiveData에 담아 UI로 전달
                        _testPageResponseData.value = dto
                        setTestPageData(dto.result.numberOfOptions)
                    }
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun setTestPageData(numberOfOptions: Int) {
        val testPageData = mutableListOf<TestPageData>()
        val questionList = testPageResponseData.value?.result?.questions

        if (questionList != null) {
            for (question in questionList) {
                testPageData.add( TestPageData(question,0,numberOfOptions,false))
            }
        }
        _testPageList.value=testPageData
//        for (i in 0 until 20) { //api 연결 안될 시 더미 코드 (52~59 주석 처리후 실행바람)
//            // 반복할 코드
//            testPageData.add(TestPageData(QuestionDto(i,"으악?"),0,5,false))
//        }
//        _testPageList.value=testPageData

    }
    fun loadTestResult(testId: Int,submitTestRequestDto: SubmitTestRequestDto){
        viewModelScope.launch {
            try {
                DoItRepository().getTestResult(
                    testId = testId,
                    submitTestRequestDto = submitTestRequestDto,
                    onSuccess = { dto ->
                        // 여기서 받은 dto를 LiveData에 담아 UI로 전달
                        _testResult.value = dto
                    }
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
