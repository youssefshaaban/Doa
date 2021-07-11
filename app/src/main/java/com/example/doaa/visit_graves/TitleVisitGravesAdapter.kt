package com.example.doaa.visit_graves

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doaa.R
import com.example.doaa.data.Visit
import com.example.doaa.databinding.ItemLayoutHomeBinding
import com.example.doaa.databinding.ItemVisitGravitsBinding

class TitleVisitGravesAdapter(val list: List<Visit>, val click: (Int) -> Unit
                     ):RecyclerView.Adapter<TitleVisitGravesAdapter.SingleRow>() {

    inner class SingleRow(private val binding: ItemVisitGravitsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val item=list[pos]
            binding.title.text=item.name
            binding.root.setOnClickListener {
                click(pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleRow {
        return SingleRow(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_visit_gravits, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SingleRow, position: Int) {
        holder.bind(position)
    }
}