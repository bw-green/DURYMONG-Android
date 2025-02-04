package com.example.durymong.view.do_it.record.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.durymong.databinding.ItemCalendarDayBinding
import com.example.durymong.view.do_it.record.viewmodel.MonthlyRecordViewModel

class RVAdapterMonthlyRecord(
    private val context: Context,
    private val items: LiveData<List<MonthlyRecordViewModel.DateRecord>>,
    private val onItemClick: (MonthlyRecordViewModel.DateRecord) -> Unit
) : RecyclerView.Adapter<RVAdapterMonthlyRecord.ViewHolder>() {
    inner class ViewHolder(val binding: ItemCalendarDayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MonthlyRecordViewModel.DateRecord) {
            binding.tvCalendarDate.text = item.date
            binding.vCalendarCircle.alpha = if (item.activityCount >= 3) {
                1f
            } else if (item.activityCount >= 2) {
                0.7f
            } else if (item.activityCount >= 1) {
                0.3f
            } else {
                0f
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding = ItemCalendarDayBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.value?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.value?.get(position)
        if (item == null){
            holder.binding.tvCalendarDate.text = ""
            holder.binding.vCalendarCircle.visibility = View.INVISIBLE
        } else{
            holder.bind(item)
        }
    }

}