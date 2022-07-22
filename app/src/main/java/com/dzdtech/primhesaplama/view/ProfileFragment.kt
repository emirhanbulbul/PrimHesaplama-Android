package com.dzdtech.primhesaplama.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.databinding.FragmentProfileBinding
import com.dzdtech.primhesaplama.services.Constants
import kotlin.system.exitProcess

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.name.text = binding.name.text.toString() + Constants.userName
        binding.surname.text = binding.surname.text.toString() + Constants.userSurname


        binding.logout.setOnClickListener {
            Intent(context, LoginActivity::class.java).also {
                startActivity(it)
                onDestroy()
            }
        }

    }


}