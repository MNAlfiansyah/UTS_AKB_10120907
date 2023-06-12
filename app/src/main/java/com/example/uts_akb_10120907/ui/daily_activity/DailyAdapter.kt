package com.example.uts_akb_10120907.ui.daily_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.databinding.ItemDailyActivitiesBinding

class DailyAdapter() : RecyclerView.Adapter<DailyAdapter.ViewHolder>() {

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
        fun bind(item: DailyModel) {
            binding.run {
                dailyactivityimg.setImageResource(item.image)
                dailyactivitytitle.text = item.name
                dailyactivitydesc.text = item.desc
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<DailyModel>() {
        override fun areItemsTheSame(
            oldExampleModel: DailyModel, newExampleModel: DailyModel
        ): Boolean {
            return oldExampleModel.image == newExampleModel.image
        }

        override fun areContentsTheSame(
            oldExampleModel: DailyModel, newExampleModel: DailyModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    }