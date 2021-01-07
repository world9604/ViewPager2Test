package com.example.viewpager2test.fragment.secondFragment

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager2test.databinding.FragmentSecondBinding


class SecondFragment : Fragment(){

    private lateinit var viewModel: SecondItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSecondBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = requireActivity().obtainViewModel(SecondItemViewModel::class.java)
            vm = viewModel
            recyclerView.apply {
                setHasFixedSize(true)
                adapter = SecondRecyclerViewAdapter(arrayListOf())
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    fun <T : ViewModel> FragmentActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProvider(viewModelStore,
            ViewModelFactory.getInstance(
                application
            )
        ).get(viewModelClass)
}


class ViewModelFactory private constructor()
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(SecondItemViewModel::class.java) ->
                    SecondItemViewModel()
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE
                    ?: ViewModelFactory(
                    )
                        .also { INSTANCE = it }
            }

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}