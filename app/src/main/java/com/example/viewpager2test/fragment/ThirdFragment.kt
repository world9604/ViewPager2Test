package com.example.viewpager2test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2test.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentThirdBinding.inflate(
            inflater,
            container,
            false
        ).apply {

        }.root
    }
}