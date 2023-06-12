package com.example.uts_akb_10120907.ui.music

import MusicAdapter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.R


class MusicFragment : Fragment(R.layout.fragment_music) {

    private val musicAdapter = MusicAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val music = listOf(
            MusicModel(R.drawable.albumpic1, "Honey", "Boy Pablo",R.raw.honey),
            MusicModel(R.drawable.albumpic2, "Mungkin Takut Perubahan", "Lomba Sihir",R.raw.mungkintakutperubahan),
            MusicModel(R.drawable.albumpic3, "Ribuan Memori", " Lomba Sihir",R.raw.ribuanmemori),
            MusicModel(R.drawable.albumpic4, "Season", "Wave to Earth",R.raw.season),
            MusicModel(R.drawable.albumpic5, "Snooze", "SZA",R.raw.snooze),
        )
        val rvmusic = getView()?.findViewById<RecyclerView>(R.id.rvmusic)
        val videoView = getView()?.findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.video

        val uri = Uri.parse(videoPath)
        videoView?.setVideoURI(uri)

        val mediaController = MediaController(requireContext())
        videoView?.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        mediaController.requestFocus()

        val imageButton = getView()?.findViewById<ImageButton>(R.id.play_button)
        imageButton?.setOnClickListener {
            if (!videoView?.isPlaying!!) {
                videoView.start()
                imageButton.visibility = View.GONE
            }
        }
        rvmusic?.adapter = musicAdapter
        musicAdapter.differ.submitList(music)

    }
}