package com.example.viewpager2test.fragment.secondFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewpager2test.dto.Item

class SecondItemViewModel: ViewModel(){

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>>
        get() = _itemList

    fun onStart() {
        showItemList()
    }

    private fun showItemList() {
        _itemList.value = arrayListOf(
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item(),
            Item()
        )
    }
}