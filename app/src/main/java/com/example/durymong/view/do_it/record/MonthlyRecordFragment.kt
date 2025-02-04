package com.example.durymong.view.do_it.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.durymong.databinding.FragmentDoItMonthlyRecordBinding
import com.example.durymong.view.do_it.record.adapter.RVAdapterMonthlyRecord
import com.example.durymong.view.do_it.record.viewmodel.MonthlyRecordViewModel

class MonthlyRecordFragment: Fragment() {
    private var _binding: FragmentDoItMonthlyRecordBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapterMonthlyRecord: RVAdapterMonthlyRecord

    private val viewModel: MonthlyRecordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoItMonthlyRecordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRVAdapterMonthlyRecord()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRVAdapterMonthlyRecord() {
        TODO("Not yet implemented")
    }

}