package com.example.flag

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.leanback.widget.DiffCallback
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flag.databinding.FlagImageBinding
import com.example.flag.model.DataItem

class FlagAdapter: ListAdapter<DataItem, FlagAdapter.FlagInfoViewHolder>(DiffCallback) {

    class FlagInfoViewHolder(private var binding:
                            FlagImageBinding
    ): RecyclerView.ViewHolder(binding.root){

       // val card:CardView = binding.cerdView

        fun bind(resultsItems:DataItem) {
            binding.flagImage = resultsItems
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlagAdapter.FlagInfoViewHolder {
       return FlagInfoViewHolder(FlagImageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FlagAdapter.FlagInfoViewHolder, position: Int) {

    }
    companion object DiffCallback : DiffUtil.ItemCallback<DataItem>(){
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.name== newItem.name
        }
        override fun areContentsTheSame(oldItem:DataItem, newItem: DataItem): Boolean {
            return oldItem.name == newItem.name
        }

    }
}