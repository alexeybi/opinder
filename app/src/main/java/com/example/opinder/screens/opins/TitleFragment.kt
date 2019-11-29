package com.example.opinder


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
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

//          viewModel.eventNoOpins.observe(this, Observer { hasNoOpins ->
//                if (hasNoOpins) {
//                    val result = viewModel.votingResul.value ?: 0
//                    val action = TitleFragmentDirections.actionTitleTo
//                    noOpins()
//                }
//          })
        return binding.root
    }
}
