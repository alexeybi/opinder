package com.example.opinder.screens.no_opins


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.opinder.R
import com.example.opinder.databinding.FragmentNoopinsBinding

class NoOpinsFragment : Fragment() {

    private val viewModel: NoOpinsFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(NoOpinsFragmentViewModel::class.java)
    }


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentNoopinsBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.noOpinsFragmentViewModel= viewModel

        viewModel.voted.observe(this, Observer { alreadyVoted ->
            if (alreadyVoted) {
                this.findNavController().navigate(R.id.action_noOpinsFragment_to_resultsFragment)
            }
        })

        return binding.root
    }
}

