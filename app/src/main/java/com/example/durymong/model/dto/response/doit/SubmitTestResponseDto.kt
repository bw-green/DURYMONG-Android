package com.example.durymong.model.dto.response.doit

class SubmitTestResponseDto(
    val code:Int,
    val message: String,
    val result: SubmitResultData,
    val success: Boolean
)

data class ScoreDistributionData(
    val minScore: Int,
    val maxScore: Int,
    val description: String
)

data class SubmitResultData (
    val testName: String,
    val userName: String,
    val userScore: Int,
    val userResult: ScoreDistributionData,
    val scoreDistributionList: List<ScoreDistributionData>
)