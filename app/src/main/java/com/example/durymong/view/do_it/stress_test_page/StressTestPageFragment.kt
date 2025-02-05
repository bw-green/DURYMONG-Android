package com.example.durymong.view.do_it.stress_test_page

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.durymong.R
import com.example.durymong.databinding.FragmentStressTestPageBinding
import com.example.durymong.view.do_it.stress_test_page.model.TestPageData
import com.example.durymong.view.do_it.stress_test_page.model.TestPageViewModel

class StressTestPageFragment : Fragment() {
    private var _binding: FragmentStressTestPageBinding? = null
    private lateinit var stressRVTestPageAdapter: RVTestPageAdapter

    private val binding get() = _binding!!

    private val viewModel: TestPageViewModel by viewModels()

    private var currentTestPage = 1
    private var lastTestPage = 1

    private var start = 0
    private var end = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStressTestPageBinding.inflate(layoutInflater)

        initData()

        initRvAdapter(start, end)

        initBackButton()

        initNextButton()
        initBeforeButton()

        return binding.root
    }

    private fun initBackButton() {
        // 뒤로 가기
    }

    private fun initBeforeButton() {
        binding.ivTestBefore.setOnClickListener {
            if (currentTestPage != 1) {
                currentTestPage--
                binding.tvTestCurrentPageNumber.text = currentTestPage.toString()
                start-=6
                end =currentTestPage*6
                initRvAdapter(start, end)
                binding.tvTestNextPage.text = "다음 페이지"
            }
        }
    }

    private fun initNextButton() {
        binding.ivTestNext.setOnClickListener {
            if (currentTestPage == lastTestPage) {
                showDialog(this.requireContext())
            } else {
                currentTestPage++
                binding.tvTestCurrentPageNumber.text = currentTestPage.toString()
                if (currentTestPage == lastTestPage) {
                    binding.tvTestNextPage.text = "완료 하기"
                    start += 6
                    end = viewModel.testPageList.value?.size ?: 0
                }
                else{
                    start += 6
                    end += 6
                }
                initRvAdapter(start, end)
            }
        }
    }

    private fun initData() {
        binding.tvStressTestNumber.text = "${viewModel.testPageList.value?.size} 문항"
        currentTestPage = 1
        viewModel.testPageList.value?.size?.let {
            lastTestPage = (it - 1) / 6 + 1
        }
        binding.tvTestCurrentPageNumber.text = currentTestPage.toString()
        binding.tvTestLastPageNumber.text = lastTestPage.toString()

        if (currentTestPage == lastTestPage) {
            binding.tvTestNextPage.text = "완료 하기"
        }

        start = 0
        end = if (lastTestPage == 1) viewModel.testPageList.value?.size ?: 0 else 6
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRvAdapter(start: Int, end: Int) {
        stressRVTestPageAdapter = RVTestPageAdapter(
            viewModel.testPageList.value?.subList(start, end) ?: emptyList(),
            requireContext()
        )

        binding.rvStressTest.apply {
            adapter = stressRVTestPageAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

    private fun showDialog(context: Context) {

        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_test_result)
        dialog.setCancelable(false)

        val okButton = dialog.findViewById<ImageView>(R.id.iv_result_ok)

        okButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}