package com.dzdtech.primhesaplama.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dzdtech.primhesaplama.view.calls_screen.AllCallFragment
import com.dzdtech.primhesaplama.view.calls_screen.ClosedCallFragment
import com.dzdtech.primhesaplama.view.calls_screen.ContinuesCallFragment


class CallsViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val NUM_TABS = 3

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AllCallFragment()
            1 -> return ClosedCallFragment()
            2 -> return ContinuesCallFragment()
        }
        return AllCallFragment()
    }
}