package com.example.uts_akb_10120907.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.databinding.ItemDailyActivitiesBinding

class GalleryAdapter() : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDailyActivitiesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemDailyActivitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GalleryModel) {
            binding.run {
                dailyactivityimg.setImageResource(item.image)
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<GalleryModel>() {
        override fun areItemsTheSame(
            oldExampleModel: GalleryModel, newExampleModel: GalleryModel
        ): Boolean {
            return oldExampleModel.image == newExampleModel.image
        }

        override fun areContentsTheSame(
            oldExampleModel: GalleryModel, newExampleModel: GalleryModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    }