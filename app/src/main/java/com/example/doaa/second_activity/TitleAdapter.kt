package com.example.doaa.second_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doaa.R
import com.example.doaa.databinding.ItemLayoutHomeBinding

class TitleAdapter(val list: List<String>, val click: (Int) -> Unit
                     ):RecyclerView.Adapter<TitleAdapter.SingleRow>() {

    inner class SingleRow(private val binding: ItemLayoutHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val item=list[pos]
            binding.title.text=item
            binding.root.setOnClickListener {
                click(pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleRow {
        return SingleRow(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_layout_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SingleRow, position: Int) {
        holder.bind(position)
    }
}