package com.example.uts_akb_10120907.ui.daily_activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120907.R
import com.google.android.material.tabs.TabLayout

class DailyActivityFragment : Fragment(R.layout.fragment_daily_activity) {

    private val friendAdapter = FriendAdapter()
    private val dailyAdapter = DailyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val friend = listOf(
            FriendModel(R.drawable.friendpic1,"Mustapha","Devops Engineer"),
            FriendModel(R.drawable.friendpic2,"Johndy","Devops Engineer"),
            FriendModel(R.drawable.friendpic3,"Dennie","UI/UX"),
            FriendModel(R.drawable.friendpic4,"Ristian","Full Stack Developer"),
            FriendModel(R.drawable.friendpic5,"Putu","Web Developer"),
        )

        val daily = listOf(
            DailyModel(R.drawable.dailypic1,"Gym","Workout"),
            DailyModel(R.drawable.dailypic2,"Badminton","Weekly Badminton"),
            DailyModel(R.drawable.dailypic3,"Trading","Learning and Execute the Market"),
            DailyModel(R.drawable.dailypic4,"Study","College"),
            DailyModel(R.drawable.dailypic5,"Chilling","going hangout or just chilling at home")
        )

        val rvfriend = getView()?.findViewById<RecyclerView>(R.id.rvfriend)
        rvfriend?.adapter = friendAdapter
        friendAdapter.differ.submitList(friend)

        val rvdaily = getView()?.findViewById<RecyclerView>(R.id.rvdailyactivities)
        rvdaily?.adapter = dailyAdapter
        dailyAdapter.differ.submitList(daily)
    }
}
