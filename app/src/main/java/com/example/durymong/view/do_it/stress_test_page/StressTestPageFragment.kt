package com.example.durymong.view.do_it.stress_test_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.durymong.databinding.FragmentStressTestPageBinding
import com.example.durymong.view.do_it.stress_test_page.model.TestPageData

class StressTestPageFragment : Fragment() {
    private var _binding: FragmentStressTestPageBinding? = null
    private lateinit var stressRVTestPageAdapter: RVTestPageAdapter
    private var dataList = ArrayList<TestPageData>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStressTestPageBinding.inflate(layoutInflater)

        initDummyData()
        initRvAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initDummyData() {
        dataList.addAll(
            arrayListOf(
                TestPageData(
                    "1. 쉽게 짜증이 나고 기분의 변동이 심하다."
                ),
                TestPageData(
                    "2. 피부가 거칠고 각종 피부 질환이 심해졌다."
                ),
                TestPageData(
                    "3. 온몸의 근육이 긴장되고 여기저기 쑤신다."
                ),
                TestPageData(
                    "4. 수면 장애를 겪는다."
                ),
                TestPageData(
                    "5. 매사에 자신이 없고 자기 비하를 많이 한다."
                ),
                TestPageData(
                    "6. 별다른 이유 없이 불안 초조하다."
                ),
                TestPageData(
                    "7. 쉽게 피로감을 느낀다."
                ),
                TestPageData(
                    "8. 매사에 집중이 잘 안되고 일이나 학습 능률이 떨어진다."
                )
            )
        )
        binding.tvStressTestNumber.text = "${dataList.size} 문항"
    }

    private fun initRvAdapter() {
        stressRVTestPageAdapter = RVTestPageAdapter(dataList, requireContext())
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