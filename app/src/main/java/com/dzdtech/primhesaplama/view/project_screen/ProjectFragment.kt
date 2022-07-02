package com.dzdtech.primhesaplama.view.project_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.adapter.ProjectViewPagerAdapter
import com.dzdtech.primhesaplama.databinding.FragmentProjectBinding
import com.dzdtech.primhesaplama.viewmodel.ProjectViewModel
import com.google.android.material.tabs.TabLayoutMediator

class ProjectFragment : Fragment() {
    private lateinit var binding: FragmentProjectBinding
    private lateinit var viewModel: ProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_project, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProjectBinding.bind(view)
        viewModel = ViewModelProvider(this)[ProjectViewModel::class.java]

        val adapter = ProjectViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.all)
                1 -> tab.text = getString(R.string.closed)
                2 -> tab.text = getString(R.string.continues)
            }
        }.attach()

    }


}


