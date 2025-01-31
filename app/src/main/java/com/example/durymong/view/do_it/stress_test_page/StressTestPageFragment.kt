package com.example.durymong.view.do_it.stress_test_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.durymong.databinding.FragmentStressTestPageBinding
import com.example.durymong.view.do_it.stress_test_page.model.TestPageData
import com.example.durymong.view.do_it.stress_test_page.model.TestPageViewModel

class StressTestPageFragment : Fragment() {
    private var _binding: FragmentStressTestPageBinding? = null
    private lateinit var stressRVTestPageAdapter: RVTestPageAdapter

    private val binding get() = _binding!!

    private val viewModel: TestPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStressTestPageBinding.inflate(layoutInflater)

        initRvAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRvAdapter() {
        stressRVTestPageAdapter = RVTestPageAdapter(viewModel.testPageList, requireContext())
        binding.tvStressTestNumber.text = "${viewModel.testPageList.value?.size} 문항"
        binding.rvStressTest.apply {
            adapter = stressRVTestPageAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }


}