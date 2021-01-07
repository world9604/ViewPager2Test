package com.example.viewpager2test.fragment.secondFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2test.databinding.VerticalViewItemBinding
import com.example.viewpager2test.dto.Item

class SecondRecyclerViewAdapter(private var items: List<Item>)
    :RecyclerView.Adapter<SecondRecyclerViewAdapter.VerticalViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .run {
                VerticalViewHolder(this)
            }
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

    // ViewHolder
    class VerticalViewHolder(private val binding: VerticalViewItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(item: Item) {
            binding.item = item
        }
    }
}