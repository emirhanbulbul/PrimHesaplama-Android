package com.dzdtech.primhesaplama.view.calls_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.viewmodel.CallViewModel

class ClosedCallFragment : Fragment() {
    private lateinit var viewModel: CallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call_closed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CallViewModel::class.java]

    }
}