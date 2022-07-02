package com.dzdtech.primhesaplama.view.calls_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.adapter.CallsViewPagerAdapter
import com.dzdtech.primhesaplama.databinding.FragmentCallBinding
import com.dzdtech.primhesaplama.viewmodel.CallViewModel
import com.google.android.material.tabs.TabLayoutMediator

class CallFragment : Fragment() {
    private lateinit var binding: FragmentCallBinding
    private lateinit var viewModel: CallViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CallViewModel::class.java]
        binding= FragmentCallBinding.bind(view)

        val adapter = CallsViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // tab.text = animalsArray[position]
            when(position){
                0 -> tab.text = getString(R.string.all)
                1 -> tab.text = getString(R.string.closed)
                2 -> tab.text = getString(R.string.continues)
            }
        }.attach()

    }



}