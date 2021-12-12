package com.example.workexpt.view.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.workexpt.R
import com.example.workexpt.databinding.FragmentListCharactersBinding
import com.example.workexpt.viewModel.ListCharactersViewModel


class ListCharactersFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = activity?.let { ListCharactersViewModel(it.application) }
        val binding: FragmentListCharactersBinding = DataBindingUtil
            .inflate(inflater,R.layout.fragment_list_characters, container, false)
        binding.viewmodel = viewModel
        return binding.root
    }
}