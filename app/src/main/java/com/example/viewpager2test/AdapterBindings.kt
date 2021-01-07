package com.example.viewpager2test

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

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
    fun bindSrc(imageView: AppCompatImageView, imagePath: String?) {
        Log.d(TEST, "bind:src : " + imagePath)
        /*val path = KimpusConfig.getFileServer() + imagePath
        Picasso.get()
                .load(path)
                .placeholder(R.drawable.campustalk_logo)
                .error(R.drawable.campustalk_logo)
                .fit()
                .into(imageView)*/
    }
}