package com.example.durymong.view.column

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.durymong.databinding.FragmentColumnDetailBinding
import com.example.durymong.util.getSafeParcelable
import com.example.durymong.view.column.viewmodel.ColumnViewModel

class ColumnDetailFragment: Fragment() {
    private var _binding: FragmentColumnDetailBinding? = null
    private val binding get() = _binding!!
    private val columnData : ColumnViewModel.Column? by lazy {
        arguments?.getSafeParcelable("columnData")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColumnDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //전달받은 Column 객체를 사용하여 UI 업데이트
        columnData?.let {
            binding.ivColumnImg.setImageResource(it.imgId)
            binding.tvColumnHeadline.text = it.headLine
            binding.tvColumnTitle.text = it.title
            binding.tvColumnBody.text = it.body
        }

        binding.ivTopAppBarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}