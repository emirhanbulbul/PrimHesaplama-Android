package com.dzdtech.primhesaplama.view.calls_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.adapter.ViewPagerAdapter
import com.dzdtech.primhesaplama.databinding.FragmentCallBinding
import com.dzdtech.primhesaplama.viewmodel.CallViewModel
import com.google.android.material.tabs.TabLayoutMediator

class CallFragment : Fragment() {
    private var fragmentCallBinding: FragmentCallBinding? = null
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
        val binding= FragmentCallBinding.bind(view)
        fragmentCallBinding = binding

        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // tab.text = animalsArray[position]
            when(position){
                0 -> tab.text = getString(R.string.all)
                1 -> tab.text = getString(R.string.closed)
                2 -> tab.text = getString(R.string.continues)
                3 -> tab.text = getString(R.string.canceled)
            }
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentCallBinding = null
    }

}