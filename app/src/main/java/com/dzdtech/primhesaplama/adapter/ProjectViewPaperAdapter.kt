package com.dzdtech.primhesaplama.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dzdtech.primhesaplama.view.project_screen.AllProjectFragment
import com.dzdtech.primhesaplama.view.project_screen.ClosedProjectFragment
import com.dzdtech.primhesaplama.view.project_screen.ContinuesProjectFragment

class ProjectViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val NUM_TABS = 3

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AllProjectFragment()
            1 -> return ClosedProjectFragment()
            2 -> return ContinuesProjectFragment()
        }
        return AllProjectFragment()
    }
}