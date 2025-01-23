package com.example.durymong.view.column.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.durymong.databinding.ItemColumnCategoryBinding
import com.example.durymong.view.column.viewmodel.ColumnViewModel

class RVAdapterColumnCategory(
    private val context: Context,
    private val items: LiveData<List<ColumnViewModel.ColumnCategory>>,
    private val onItemClick: (ColumnViewModel.ColumnCategory) -> Unit
) : RecyclerView.Adapter<RVAdapterColumnCategory.ViewHolder>() {
    inner class ViewHolder(val binding: ItemColumnCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ColumnViewModel.ColumnCategory) {
            binding.ivColumnCategoryIcon.setImageResource(item.imgId)
            binding.columnCategoryName.text = item.name
            binding.cardColumnCategory.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVAdapterColumnCategory.ViewHolder {
        val binding = ItemColumnCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.value?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items.value?.get(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}