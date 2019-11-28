package com.example.opinder.screens.no_opins


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.opinder.R
import com.example.opinder.databinding.FragmentNoopinsBinding

/**
 * A simple [Fragment] subclass.
 */
class NoOpinsFragment : Fragment() {

    private lateinit var viewModel: NoOpinsFragmentViewModel
    private lateinit var binding: FragmentNoopinsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_noopins, container, false)
            return binding.root

            viewModel = ViewModelProviders.of(this).get(NoOpinsFragmentViewModel::class.java)

            binding.noOpinsFragmentViewModel = viewModel
            binding.lifecycleOwner = this

        }
    }


}
