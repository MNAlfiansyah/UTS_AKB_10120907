package com.example.uts_akb_10120907.ui.music

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.databinding.ItemDailyActivitiesBinding
import com.example.uts_akb_10120907.databinding.ItemMusicBinding

class Videodapter() : RecyclerView.Adapter<Videodapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMusicBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MusicModel) {
            binding.run {
                albumpic.setImageResource(item.image)
                songtitle.text = item.name
                songartist.text = item.desc
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<MusicModel>() {
        override fun areItemsTheSame(
            oldExampleModel: MusicModel, newExampleModel: MusicModel
        ): Boolean {
            return oldExampleModel.image == newExampleModel.image
        }

        override fun areContentsTheSame(
            oldExampleModel: MusicModel, newExampleModel: MusicModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    }