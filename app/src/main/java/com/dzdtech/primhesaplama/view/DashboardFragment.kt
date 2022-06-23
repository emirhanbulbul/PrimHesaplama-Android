package com.dzdtech.primhesaplama.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.viewmodel.DashboardViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {
    private val TAG = "Dashboard Fragment"

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch{
            viewModel.getData()
        }

        viewModel.data.observe(viewLifecycleOwner) { userList ->
            Log.e(TAG, "$userList")

            topPrimHakedis?.text = userList.topPrim.toString()
            cagriPrimHakedis.text = userList.cagriPrim.toString()
            projePrimHakedis.text = userList.projePrim.toString()
            acikProje.text = userList.acikProje.toString()

            //Progress bar gizleme
            if (!viewModel.progress) {
                progress_Bar?.visibility = View.GONE
            }
        }


    }

}