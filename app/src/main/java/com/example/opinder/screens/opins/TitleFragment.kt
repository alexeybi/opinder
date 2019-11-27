package com.example.opinder


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.opinder.screens.opins.TitleFragmentViewModel
import com.example.opinder.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var viewModel: TitleFragmentViewModel
    private lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
            return binding.root

            viewModel = ViewModelProviders.of(this).get(TitleFragmentViewModel::class.java)

            binding.disagreeButton.setOnClickListener{
                viewModel.onDisagree()
                //TODO  update screen on disagree actions
            }

            binding.neutralButton.setOnClickListener{
                viewModel.onNeutral()
                //TODO updatea screen on neutral actions
            }

            binding.agreeButton.setOnClickListener{
                viewModel.onAgree()
                //TODO update screen on agree actions
            }


            private fun noOpins() {
                val disagreeStatResult = viewModel.disagreeStat.value ?: 0
                val neutralStatResult = viewModel.neutralStat.value ?: 0
                val agreeStatResult = viewModel.agreeStat.value ?: 0

                val action = TitleFragmentDirections.actionStatResults()
                Navigation.findNavController(this).


            }


            viewModel.disagreeStat.observe(this, Obeserver { addDisagreeStat ->
                //TODO imlement text result in layout
                binding.disagreeTextResult.text = addDisagreeStat.toString()

            })

            viewModel.neutralStat.observe(this, Obeserver{ addNeutralStat ->
                //TODO imlement text result in layout
                binding.neutralTextStat.text = addNeutralStat.toString()
            })

            viewModel.agreeStat.observe(this, Observer{ addAgreeStat ->
                //TODO imlement text result in layout
                binding.agreeTextStat.text = addAgreeStat.toString()
            })




        }
    }
