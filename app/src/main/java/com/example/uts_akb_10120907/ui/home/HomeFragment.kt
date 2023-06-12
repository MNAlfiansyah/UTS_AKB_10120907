package com.example.uts_akb_10120907.ui.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uts_akb_10120907.R
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val card1: MaterialCardView = view.findViewById(R.id.card1)
        val card2: MaterialCardView = view.findViewById(R.id.card2)
        val card3: MaterialCardView = view.findViewById(R.id.card3)
        val card4: MaterialCardView = view.findViewById(R.id.card4)
        val card5: MaterialCardView = view.findViewById(R.id.card5)

        card1.setOnClickListener {
            showPopupDialog(R.layout.dialog_hobbies)
        }

        card2.setOnClickListener {
            showPopupDialog(R.layout.dialog_interest)
        }

        card3.setOnClickListener {
            showPopupDialog(R.layout.dialog_food)
        }

        card4.setOnClickListener {
            showPopupDialog(R.layout.dialog_drink)
        }

        card5.setOnClickListener {
            showPopupDialog(R.layout.dialog_dreams)
        }
    }

    private fun showPopupDialog(layoutResId: Int) {
        val inflater = LayoutInflater.from(requireContext())
        val popupView = inflater.inflate(layoutResId, null)

        // Create and show the popup dialog
        val popupDialog = Dialog(requireContext())
        popupDialog.setContentView(popupView)

        // Adjust dialog size
        val layoutParams = popupDialog.window?.attributes
        layoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
        layoutParams?.height = ViewGroup.LayoutParams.WRAP_CONTENT
        popupDialog.window?.attributes = layoutParams

        popupDialog.show()
    }
}
