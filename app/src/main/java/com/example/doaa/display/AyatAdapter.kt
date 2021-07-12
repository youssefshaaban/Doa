package com.example.doaa.display

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doaa.R
import com.example.doaa.databinding.ItemImageBinding


class AyatAdapter(val list: List<Int>) :
    RecyclerView.Adapter<AyatAdapter.SingleRowCourse>() {

    inner class SingleRowCourse(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val item=list[pos]
            binding.image.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleRowCourse {
        return SingleRowCourse(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_image,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SingleRowCourse, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}