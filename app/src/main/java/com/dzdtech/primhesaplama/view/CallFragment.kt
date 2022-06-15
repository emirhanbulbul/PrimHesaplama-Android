package com.dzdtech.primhesaplama.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.viewmodel.CallViewModel
import com.dzdtech.primhesaplama.viewmodel.ProjectViewModel

class CallFragment : Fragment() {

    companion object {
        fun newInstance() = CallFragment()
    }

    private lateinit var viewModel: CallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CallViewModel::class.java)

    }

}