package com.example.durymong.view.do_it

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.durymong.R
import com.example.durymong.databinding.FragmentDoItBinding

class DoItFragment : Fragment() {
    private var _binding: FragmentDoItBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoItBinding.inflate(layoutInflater)

        initWalk()

        initStressTest()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initWalk() {
        _binding?.ivDoItWalk?.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_fragment_do_it_to_fragment_do_it_walk)
        }
    }

    private fun initStressTest() {
        _binding?.cvDoItStressLevelTest?.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_fragment_do_it_to_fragment_stress_test_page)
        }
    }
}