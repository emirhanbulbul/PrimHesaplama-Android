package com.dzdtech.primhesaplama.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.databinding.FragmentDashboardBinding
import com.dzdtech.primhesaplama.services.Constants
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)

        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        binding.welcomeText.text = "Hoşgeldin, ${Constants.userName + " " + Constants.userSurname}"

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()
        }

        viewModel.data.observe(viewLifecycleOwner) {
            Log.e(TAG, "$it")

            binding.topPrimHakedis.text = it[Constants.idValue.toInt()].toplamPrimHakedis.toString()
            binding.cagriPrimHakedis.text = it[Constants.idValue.toInt()].itsmPrimHakedis.toString()
            binding.projePrimHakedis.text = it[Constants.idValue.toInt()].projectPrimHakedis.toString()
            binding.acikProje.text = it[Constants.idValue.toInt()].projectAndItsmCount.toString()

            //Progress bar gizleme
            if (!viewModel.progress) {
                binding.progressBar.visibility = View.GONE
            }
        }


    }

}