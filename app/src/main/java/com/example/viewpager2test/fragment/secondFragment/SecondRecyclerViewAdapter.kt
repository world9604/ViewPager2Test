package com.example.viewpager2test.fragment.secondFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2test.databinding.VerticalViewItemBinding
import com.example.viewpager2test.dto.Item

class SecondRecyclerViewAdapter(var items: List<Item>)
    :RecyclerView.Adapter<SecondRecyclerViewAdapter.VerticalViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val binding = VerticalViewItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return VerticalViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItem(itemList: List<Item>) {
        items = itemList
        notifyDataSetChanged()
    }

    class VerticalViewHolder(private val binding: VerticalViewItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(item: Item) {
            binding.item = item
        }
    }
}