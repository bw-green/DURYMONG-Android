package com.example.durymong.view.do_it.stress_test_page

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.durymong.R
import com.example.durymong.databinding.ItemTestBinding
import com.example.durymong.databinding.ItemTestCompleteBinding
import com.example.durymong.view.do_it.stress_test_page.model.TestPageData

class RVTestPageAdapter(private val itemList: List<TestPageData>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_NORMAL = 0
        private const val VIEW_TYPE_LAST = 1
    }

    inner class ItemViewHolder(
        private val binding: ItemTestBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TestPageData) {
            binding.tvQuestionName.text = item.name
        }
    }

    inner class LastItemViewHolder(
        private val binding: ItemTestCompleteBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.ivTestComplete.setOnClickListener {
                showDialog(context)
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemList.size) {
            VIEW_TYPE_LAST
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_LAST) {
            val binding =
                ItemTestCompleteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LastItemViewHolder(binding)
        } else {
            val binding =
                ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ItemViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LastItemViewHolder) {
            holder.bind()
        } else if (holder is ItemViewHolder) {
            holder.bind(itemList[position])
        }
    }

    override fun getItemCount(): Int {
        return itemList.size + 1
    }

    fun showDialog(context: Context) {

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