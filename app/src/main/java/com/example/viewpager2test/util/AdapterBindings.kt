package com.example.viewpager2test.util

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2test.R
import com.example.viewpager2test.fragment.secondFragment.SecondRecyclerViewAdapter
import com.example.viewpager2test.dto.Item
import com.squareup.picasso.Picasso

object AdapterBindings {

    const val TEST = "test@123"

    @BindingAdapter("bind:item")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, itemList: List<Item>?) {
        Log.d(TEST, "bind:item")
        with(recyclerView.adapter as SecondRecyclerViewAdapter) {
            itemList?.let {
                setItem(it)
            }
        }
    }
}