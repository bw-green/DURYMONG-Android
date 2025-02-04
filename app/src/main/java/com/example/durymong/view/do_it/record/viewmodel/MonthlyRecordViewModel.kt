package com.example.durymong.view.do_it.record.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MonthlyRecordViewModel : ViewModel() {
    private val _monthlyRecordList = MutableLiveData<List<DateRecord>>()
    val monthlyRecordList: LiveData<List<DateRecord>> get() = _monthlyRecordList

    private val _currentMonth = MutableLiveData<Int>()
    val currentMonth: LiveData<Int> get() = _currentMonth


    init {
        _currentMonth.value = 2
        _currentMonth.value?.let { fetchMonthlyRecordData(it) }
    }

    fun fetchMonthlyRecordData(currentMonth: Int) {
        viewModelScope.launch {
            _monthlyRecordList.value = listOf(
                DateRecord("2025-02-01", 0),
                DateRecord("2025-02-02", 0),
                DateRecord("2025-02-03", 0),
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
    }

    data class DateRecord(
        val date: String,
        val activityCount: Int
    )
}