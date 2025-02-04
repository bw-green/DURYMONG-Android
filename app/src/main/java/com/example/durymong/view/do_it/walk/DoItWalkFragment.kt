package com.example.durymong.view.do_it.walk

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import com.example.durymong.databinding.FragmentDoItWalkBinding
import com.example.durymong.view.do_it.walk.viewmodel.WalkViewModel
import kotlinx.coroutines.launch

class DoItWalkFragment : Fragment(){

    private var _binding: FragmentDoItWalkBinding? = null
    private val binding get() = _binding!!

    private lateinit var circularProgressBar: ProgressBar

    private val viewModel : WalkViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoItWalkBinding.inflate(layoutInflater)



        initTimer()
        initTimerSetting()
        lifecycleScope.launch {
            viewModel.timeData.asFlow().collect { time ->
                binding.tvDoItWalkTime.text = "${time.first}시간 ${time.second}분"
                Log.d("time", time.toString())
            }
        }

        Log.d("onCreateView", "onCreateView")
        return binding.root
    }


    private fun initTimerSetting() {
        val bottomSheet = TimerBottomSheet()
        _binding?.ivDoItWalkDownArrow?.setOnClickListener {
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
            viewModel.isDialogOpen.observe(viewLifecycleOwner) { isOpen ->
                if (!isOpen) {
                    println("다이얼로그가 닫힘을 감지")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initTimer() {
        circularProgressBar = binding.pbDoItWalk

        val animator = ObjectAnimator.ofInt(circularProgressBar, "progress", 0, 100)
        animator.duration = 5 * 1000 // 1000=1초
        animator.interpolator = LinearInterpolator() // 일정한 속도
        animator.start()

    }

}