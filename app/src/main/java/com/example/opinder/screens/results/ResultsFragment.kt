package com.example.opinder.screens.results


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.opinder.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private val viewModel: ResultsFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(ResultsFragmentViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        val binding = FragmentResultsBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.resultsViewModel = viewModel
        binding.cardsList.adapter = CardsResultAdapter()


        return binding.root
    }
}

