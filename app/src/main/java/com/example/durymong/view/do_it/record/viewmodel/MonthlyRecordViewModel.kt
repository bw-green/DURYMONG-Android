package com.example.durymong.view.do_it.record.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class MonthlyRecordViewModel : ViewModel() {
    private val _monthlyRecordList = MutableLiveData<List<DateRecord>>()
    val monthlyRecordList: LiveData<List<DateRecord>> get() = _monthlyRecordList

    private val _currentMonth = MutableLiveData<YearMonth>()
    val currentMonth: LiveData<YearMonth> get() = _currentMonth

    init {
        val currentDate = LocalDate.now()
        _currentMonth.value = YearMonth.from(currentDate)
        updateMonthlyRecord(_currentMonth.value!!)
    }

    fun changeMonth(offset: Int){
        _currentMonth.value = _currentMonth.value?.plusMonths(offset.toLong())
        updateMonthlyRecord(_currentMonth.value!!)
    }

    fun updateMonthlyRecord(yearMonth: YearMonth) {
        val firstDayOfMonth = yearMonth.atDay(1)
        val lastDayOfMonth = yearMonth.lengthOfMonth()
        val startDayOfWeek = firstDayOfMonth.dayOfWeek.value
        val recordList = mutableListOf<DateRecord>()

        // 빈 칸 추가 (시작 요일 맞추기)
        for (i in 0 until startDayOfWeek) {
            recordList.add(DateRecord("", 0))
        }
        val fetchedData = fetchDataFromServer(yearMonth)
        // 날짜에 해당하는 활동 개수 매핑
        val dateActivityMap = fetchedData.associateBy { it.date }
        for (day in 1..lastDayOfMonth) {
            val dateString = yearMonth.atDay(day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            val activityCount = dateActivityMap[dateString]?.count?: 0
            recordList.add(DateRecord(dateString, activityCount))
        }
        // _monthlyRecordList 업데이트
        _monthlyRecordList.value = recordList
    }

    fun fetchDataFromServer(yearMonth: YearMonth): List<DateRecord> {
        //서버에서 데이터를 가져오는 코드
        return listOf(
            DateRecord("2025-02-01", 1),
            DateRecord("2025-02-02", 2),
            DateRecord("2025-02-03", 3),
            DateRecord("2025-02-04", 0),
            DateRecord("2025-02-05", 0),
            DateRecord("2025-02-06", 0),
            DateRecord("2025-02-07", 0),
            DateRecord("2025-02-08", 0),
            DateRecord("2025-02-09", 0),
            DateRecord("2025-02-10", 0),
            DateRecord("2025-02-11", 0),
            DateRecord("2025-02-12", 0),
            DateRecord("2025-02-13", 0),
            DateRecord("2025-02-14", 0),
            DateRecord("2025-02-15", 0),
            DateRecord("2025-02-16", 0),
            DateRecord("2025-02-17", 0),
            DateRecord("2025-02-18", 0),
            DateRecord("2025-02-19", 0),
            DateRecord("2025-02-20", 0),
            DateRecord("2025-02-21", 0),
            DateRecord("2025-02-22", 0),
            DateRecord("2025-02-23", 0),
            DateRecord("2025-02-24", 0),
            DateRecord("2025-02-25", 0),
            DateRecord("2025-02-26", 0),
            DateRecord("2025-02-27", 0),
            DateRecord("2025-02-28", 0),
        )
    }

    data class DateRecord(
        val date: String,
        val count: Int
    )
}
