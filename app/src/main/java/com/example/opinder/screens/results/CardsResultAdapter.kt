package com.example.opinder.screens.results

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.opinder.databinding.CardsViewItemBinding
import com.example.opinder.databinding.FragmentResultsBinding
import com.example.opinder.databinding.FragmentTitleBinding
import com.example.opinder.network.OpinderApiProperties
import com.example.opinder.screens.opins.TitleFragmentViewModel

class CardsResultAdapter : ListAdapter<OpinderApiProperties, CardsResultAdapter.OpinderApiProperitesViewHolder>(DiffCallback){
    class OpinderApiProperitesViewHolder(private var binding: CardsViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(apiProperties: OpinderApiProperties){
            binding.card = apiProperties
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<OpinderApiProperties>(){
        override fun areItemsTheSame(
            oldItem: OpinderApiProperties,
            newItem: OpinderApiProperties
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: OpinderApiProperties,
            newItem: OpinderApiProperties
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardsResultAdapter.OpinderApiProperitesViewHolder {
        return OpinderApiProperitesViewHolder(CardsViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: CardsResultAdapter.OpinderApiProperitesViewHolder,
        position: Int
    ) {
        val cardProperty = getItem(position)
        holder.bind(cardProperty)

    }

}