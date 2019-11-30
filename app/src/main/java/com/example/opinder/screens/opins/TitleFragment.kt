package com.example.opinder


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.opinder.databinding.FragmentTitleBinding
import com.example.opinder.screens.opins.TitleFragmentViewModel

class TitleFragment : Fragment() {

    private val viewModel: TitleFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(TitleFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val binding = FragmentTitleBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.titleFragmentViewModel = viewModel

        //Event listener to navigate to results when voted on all cards
        viewModel.noCardsLeft.observe(this, Observer { hasNoCards->
            if (hasNoCards) {
                this.findNavController().navigate(R.id.action_titleFragment_to_noOpinsFragment)
                viewModel.onNoCardsLeft()
            }
      })
        return binding.root
    }
}
