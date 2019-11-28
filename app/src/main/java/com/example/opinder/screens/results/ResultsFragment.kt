package com.example.opinder.screens.results


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.opinder.R
import com.example.opinder.databinding.FragmentResultsBinding

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment() {

    private lateinit var viewModelFactory: FragmentResultsBinding
    private lateinit var viewModel: ResultsFragmentViewModel
    private lateinit var binding: FragmentResultsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        //inflate view and get instance of the binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_results,container, false)
        return binding.root

    }
}

