package com.example.uts_akb_10120907.ui.daily_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.databinding.ItemFriendBinding

class FriendAdapter() : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFriendBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FriendModel) {
            binding.run {
                friendimg.setImageResource(item.image)
                friendname.text = item.name
                friendprof.text = item.desc
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<FriendModel>() {
        override fun areItemsTheSame(
            oldExampleModel: FriendModel, newExampleModel: FriendModel
        ): Boolean {
            return oldExampleModel.image == newExampleModel.image
        }

        override fun areContentsTheSame(
            oldExampleModel: FriendModel, newExampleModel: FriendModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    }