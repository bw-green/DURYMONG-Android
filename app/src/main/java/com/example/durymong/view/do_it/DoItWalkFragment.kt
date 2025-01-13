package com.example.durymong.view.do_it

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import com.example.durymong.R
import com.example.durymong.databinding.FragmentDoItBinding
import com.example.durymong.databinding.FragmentDoItWalkBinding


class DoItWalkFragment : Fragment() {
    private lateinit var binding: FragmentDoItWalkBinding
    private lateinit var circularProgressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoItWalkBinding.inflate(layoutInflater)

        initTimer()

        return binding.root
    }

    private fun initTimer() {
        circularProgressBar=binding.pbDoItWalk

        val animator = ObjectAnimator.ofInt(circularProgressBar, "progress", 0, 100)
        animator.duration = 5000 // 5초
        animator.interpolator = LinearInterpolator() // 일정한 속도
        animator.start()

    }

}