package com.example.opinder.screens.no_opins


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.opinder.databinding.FragmentNoopinsBinding

class NoOpinsFragment : Fragment() {

    private val viewModel: NoOpinsFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(NoOpinsFragmentViewModel::class.java)
    }


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentNoopinsBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.noOpinsFragmentViewModel= viewModel

        return binding.root
    }
}

