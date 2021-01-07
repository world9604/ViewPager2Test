package com.example.viewpager2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2test.databinding.ActivityMainBinding
import com.example.viewpager2test.fragment.FirstFragment
import com.example.viewpager2test.fragment.secondFragment.SecondFragment
import com.example.viewpager2test.fragment.ThirdFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.lifecycleOwner = this

        val pagerAdapter = PagerFragmentStateAdapter(this)
        pagerAdapter.addFragment(FirstFragment())
        pagerAdapter.addFragment(SecondFragment())
        pagerAdapter.addFragment(ThirdFragment())

        val viewPager = binding.pager
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("ViewPagerFragment", "Page ${position+1}")
            }
        })

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }
}