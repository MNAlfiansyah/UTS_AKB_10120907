package com.example.uts_akb_10120907.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.R
import com.example.uts_akb_10120907.ui.daily_activity.FriendModel

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val galleryAdapter = GalleryAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gallery = listOf(
            GalleryModel(R.drawable.gallerypic1),
            GalleryModel(R.drawable.gallerypic2),
            GalleryModel(R.drawable.gallerypic3),
            GalleryModel(R.drawable.gallerypic4),
            GalleryModel(R.drawable.gallerypic5),
            GalleryModel(R.drawable.gallerypic6),
            GalleryModel(R.drawable.gallerypic7),
            GalleryModel(R.drawable.gallerypic8),
            GalleryModel(R.drawable.gallerypic9),
            GalleryModel(R.drawable.gallerypic10),
            GalleryModel(R.drawable.gallerypic11),
            GalleryModel(R.drawable.gallerypic12),
            GalleryModel(R.drawable.gallerypic13),
            GalleryModel(R.drawable.gallerypic14),
            GalleryModel(R.drawable.gallerypic15),
        )

        val rvgallery = getView()?.findViewById<RecyclerView>(R.id.rvgallery)
        rvgallery?.adapter = galleryAdapter
        galleryAdapter.differ.submitList(gallery)
    }
}