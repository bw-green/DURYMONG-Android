package com.example.durymong.view.do_it.stress_test_page

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.durymong.R
import com.example.durymong.databinding.ItemTestCompleteBinding
import com.example.durymong.databinding.ItemTestFourBinding
import com.example.durymong.databinding.ItemTestThreeBinding
import com.example.durymong.view.do_it.stress_test_page.model.TestPageData

class RVTestPageAdapter(
    private val itemList: LiveData<List<TestPageData>>,
    private val context: Context
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val VIEW_TYPE_FOUR = 0
        private const val VIEW_TYPE_THREE = 1
        private const val VIEW_TYPE_LAST = 2

    }

    inner class ThreeItemViewHolder(
        private val binding: ItemTestThreeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TestPageData) {
            binding.tvQuestionName.text = item.name
        }
    }

    inner class FourItemViewHolder(
        private val binding: ItemTestFourBinding
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
        return if (position == itemList.value?.size!!) {
            VIEW_TYPE_LAST
        } else {
            if (itemList.value?.getOrNull(position)?.number == 4) {
                VIEW_TYPE_FOUR
            } else
                VIEW_TYPE_THREE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LAST -> {
                val binding =
                    ItemTestCompleteBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                LastItemViewHolder(binding)
            }

            VIEW_TYPE_THREE -> {
                val binding =
                    ItemTestThreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ThreeItemViewHolder(binding)
            }

            else -> {
                val binding =
                    ItemTestFourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FourItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LastItemViewHolder -> {
                holder.bind()
            }

            is ThreeItemViewHolder -> {
                holder.bind(itemList.value?.getOrNull(position)!!)
            }

            else -> {
                holder as FourItemViewHolder
                holder.bind(itemList.value?.getOrNull(position)!!)
            }
        }
    }

    override fun getItemCount(): Int {
        if (itemList.value == null) return 0  // api 연결 오류로 인한 null
        return itemList.value?.size!! + 1
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