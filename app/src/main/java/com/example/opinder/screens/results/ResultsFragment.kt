package com.example.opinder.screens.results


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.opinder.R
import com.example.opinder.databinding.FragmentResultsBinding
import kotlinx.android.synthetic.main.fragment_noopins.*

class ResultsFragment : Fragment() {

    private val viewModel: ResultsFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(ResultsFragmentViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        val binding = FragmentResultsBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.resultsFragmentViewModel = viewModel

        return binding.root
    }
}

