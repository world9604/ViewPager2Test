package com.example.viewpager2test

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
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

    @BindingAdapter("bind:src")
    @JvmStatic
    fun bindSrc(imageView: AppCompatImageView, imgKey: String?) {
        Log.d(TEST, "bind:src : " + imgKey)
        Picasso.get()
                .load(imgKey)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .into(imageView)
    }
}