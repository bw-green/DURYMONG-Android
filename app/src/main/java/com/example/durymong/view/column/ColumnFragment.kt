package com.example.durymong.view.column

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.durymong.databinding.FragmentColumnBinding
import com.example.durymong.view.column.viewmodel.ColumnViewModel

class ColumnFragment : Fragment() {
    private var _binding: FragmentColumnBinding? = null
    private val binding get() = _binding!!

    //viewModel 선언
    private val viewModel: ColumnViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColumnBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}