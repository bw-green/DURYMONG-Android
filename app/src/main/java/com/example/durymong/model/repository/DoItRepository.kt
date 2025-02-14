package com.example.durymong.model.repository

import android.util.Log
import com.example.durymong.model.dto.request.doit.CheckActivityRequest
import com.example.durymong.model.dto.request.doit.SubmitTestRequestDto
import com.example.durymong.model.dto.response.doit.ActivityTestListResponse
import com.example.durymong.model.dto.response.doit.SubmitTestResponseDto
import com.example.durymong.model.dto.response.doit.TestMainPageResponseDto
import com.example.durymong.model.dto.response.doit.TestPageResponseDto
import com.example.durymong.retrofit.RetrofitObject
import com.example.durymong.retrofit.service.DoItService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoItRepository {
    private val doItService: DoItService = RetrofitObject.createService()

    fun getTestData(
        testId: Int,
        onSuccess: (TestPageResponseDto) -> Unit
    ) {
        doItService.getTestPage(testId).enqueue(object : Callback<TestPageResponseDto> {
            override fun onResponse(
                call: Call<TestPageResponseDto>,
                response: Response<TestPageResponseDto>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                    Log.d("DoItRepository", "onResponseSuccess")

                }
            }
            override fun onFailure(p0: Call<TestPageResponseDto>, p1: Throwable) {
                Log.d("DoItRepository", "onFailure: ${p1.message}")
            }

        })
    }

    fun getTestMainPage(testId: Int,
                        onSuccess: (TestMainPageResponseDto) -> Unit
    ) =
        doItService.getTestMainPage(testId).enqueue(object : Callback<TestMainPageResponseDto> {
            override fun onResponse(
                call: Call<TestMainPageResponseDto>,
                response: Response<TestMainPageResponseDto>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        onSuccess(body)
                        Log.d("DoItRepository", "onResponseSuccess: $body")
                    }
                }
            }

            override fun onFailure(call: Call<TestMainPageResponseDto>, t: Throwable) {
                Log.e("DoItRepository", "onFailure: ${t.message}")
            }
        })

    fun getTestResult(testId: Int, submitTestRequestDto: SubmitTestRequestDto,onSuccess: (SubmitTestResponseDto) -> Unit)=
        doItService.submitTest(testId, submitTestRequestDto).enqueue(object : Callback<SubmitTestResponseDto> {
            override fun onResponse(
                p0: Call<SubmitTestResponseDto>,
                response: Response<SubmitTestResponseDto>
            ) {
                if(response.isSuccessful){
                    if(response.body()!=null){
                        onSuccess(response.body()!!)
                    }else{
                        Log.d("DoItRepository", "resultNull")
                    }
                }
                else{
                    Log.d("DoItRepository", "onResponseFail")
                }

            }

            override fun onFailure(p0: Call<SubmitTestResponseDto>, p1: Throwable) {
                Log.d("DoItRepository", "onFailure: ${p1.message}")
            }


        })

        fun getDoItMainPage(onSuccess: (ActivityTestListResponse) -> Unit) {
            doItService.getDoItMainPage().enqueue(object : Callback<ActivityTestListResponse> {
                override fun onResponse(
                    p0: Call<ActivityTestListResponse>,
                    p1: Response<ActivityTestListResponse>
                ) {
                    if(p1.isSuccessful){
                        if(p1.body()!=null){
                            onSuccess(p1.body()!!)
                        }else{
                            Log.d("DoItMainPage", "resultNull")
                        }
                    }
                }
                override fun onFailure(p0: Call<ActivityTestListResponse>, p1: Throwable) {
                    Log.d("DoItMainPage", "onFailure: ${p1.message}")
                }
            })
        }
    fun submitCheck(checkActivityRequest: CheckActivityRequest) {
        doItService.submitCheck(checkActivityRequest).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("doItCheck", "체크 성공")
                } else {
                    Log.e("doItCheck", "오류 코드: ${response.code()}, 메시지: ${response.errorBody()?.string()}")
                }
            }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("doItCheck", "요청 실패: ${t.message}")
            }
        })
    }
    }


