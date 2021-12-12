package com.example.workexpt.view.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.workexpt.R
import com.example.workexpt.databinding.FragmentProfileSuperheroBinding
import com.example.workexpt.viewModel.ProfileSuperheroViewModel

class ProfileSuperheroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viwemodel = activity?.let { ProfileSuperheroViewModel(it.application, arguments) }
        val binding:FragmentProfileSuperheroBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_profile_superhero, container, false)
        binding.viewmodel = viwemodel
        return binding.root
    }
}