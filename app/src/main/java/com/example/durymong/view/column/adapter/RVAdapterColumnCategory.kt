package com.example.durymong.view.column.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.durymong.databinding.ItemColumnCategoryBinding
import com.example.durymong.view.column.viewmodel.ColumnCategory

class RVAdapterColumnCategory(
    private val context: Context,
    private val items: LiveData<List<ColumnCategory>>
) : RecyclerView.Adapter<RVAdapterColumnCategory.ViewHolder>() {
    inner class ViewHolder(val binding: ItemColumnCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ColumnCategory) {
            binding.ivColumnCategoryIcon.setImageResource(item.imgId)
            binding.columnCategoryName.text = item.name
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