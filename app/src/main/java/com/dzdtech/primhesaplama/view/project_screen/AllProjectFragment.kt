package com.dzdtech.primhesaplama.view.project_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.adapter.RecyclerProjectAdapter
import com.dzdtech.primhesaplama.databinding.FragmentProjectAllBinding
import com.dzdtech.primhesaplama.viewmodel.ProjectViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllProjectFragment : Fragment() {

    private lateinit var binding: FragmentProjectAllBinding
    private lateinit var viewModel: ProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_project_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProjectAllBinding.bind(view)
        viewModel = ViewModelProvider(this)[ProjectViewModel::class.java]
        val layoutManager = LinearLayoutManager(context)
        binding.projectAllRecyclerView.layoutManager = layoutManager

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllData()
        }



        viewModel.data.observe(viewLifecycleOwner) {
            val adapter = RecyclerProjectAdapter(it)
            binding.projectAllRecyclerView.adapter = adapter
            //Progress bar gizleme
            if (!viewModel.progress) {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}