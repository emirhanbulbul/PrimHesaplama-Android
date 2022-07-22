package com.dzdtech.primhesaplama.view.calls_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.adapter.RecyclerCallAdapter
import com.dzdtech.primhesaplama.databinding.FragmentCallAllBinding
import com.dzdtech.primhesaplama.databinding.FragmentCallClosedBinding
import com.dzdtech.primhesaplama.viewmodel.CallViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClosedCallFragment : Fragment() {
    private lateinit var viewModel: CallViewModel
    private lateinit var binding: FragmentCallClosedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call_closed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCallClosedBinding.bind(view)
        viewModel = ViewModelProvider(this)[CallViewModel::class.java]
        val layoutManager = LinearLayoutManager(context)
        binding.callClosedRecyclerView.layoutManager = layoutManager

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getClosedData()
        }



        viewModel.data.observe(viewLifecycleOwner) {
            val adapter = RecyclerCallAdapter(it)
            binding.callClosedRecyclerView.adapter = adapter
            //Progress bar gizleme
            if (!viewModel.progress) {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}