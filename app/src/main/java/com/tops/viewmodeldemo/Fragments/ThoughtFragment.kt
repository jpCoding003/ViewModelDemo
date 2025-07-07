package com.tops.viewmodeldemo.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tops.viewmodeldemo.R
import com.tops.viewmodeldemo.ViewModels.QuotesViewModel
import com.tops.viewmodeldemo.databinding.FragmentThoughtBinding
import kotlin.getValue

class ThoughtFragment : Fragment() {

    private lateinit var binding: FragmentThoughtBinding
    private val quotesviewmodel: QuotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThoughtBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quotesviewmodel.quotes.observe(requireActivity(), Observer<String>{
                u-> binding.tvQuotes.setText(u)
        })

        binding.btnNext.setOnClickListener {
            quotesviewmodel.randomGenerate()
        }

    }

}