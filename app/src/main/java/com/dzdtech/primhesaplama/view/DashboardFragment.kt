package com.dzdtech.primhesaplama.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.databinding.FragmentDashboardBinding
import com.dzdtech.primhesaplama.viewmodel.DashboardViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private val TAG = "Dashboard Fragment"
    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding = FragmentDashboardBinding.bind(view)

            viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch{
            viewModel.getData()
        }

        viewModel.data.observe(viewLifecycleOwner) { userList ->
            Log.e(TAG, "$userList")

            binding.topPrimHakedis.text = userList.topPrim.toString()
            binding.cagriPrimHakedis.text = userList.cagriPrim.toString()
            binding.projePrimHakedis.text = userList.projePrim.toString()
            binding.acikProje.text = userList.acikProje.toString()

            //Progress bar gizleme
            if (!viewModel.progress) {
                binding.progressBar.visibility = View.GONE
            }
        }


    }

}