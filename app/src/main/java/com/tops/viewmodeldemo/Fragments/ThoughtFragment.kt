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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tops.viewmodeldemo.R
import com.tops.viewmodeldemo.ViewModels.QuotesViewModel
import com.tops.viewmodeldemo.databinding.FragmentThoughtBinding
import com.tops.viewmodeldemo.model.QuotesData
import kotlin.getValue

class ThoughtFragment : Fragment() {

    private lateinit var binding: FragmentThoughtBinding
    private lateinit var quotesviewmodel: QuotesViewModel

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

        quotesviewmodel= ViewModelProvider(requireActivity()).get(QuotesViewModel::class.java)
//        quotesviewmodel.quotes.observe(requireActivity(), Observer<String>{
//                u-> binding.tvQuotes.setText(u)
//        })

//        quotesviewmodel.quotes.observe(viewLifecycleOwner,  Observer<String>{
//                u-> binding.tvQuotes.text = u.toString()
//        })
//
//        binding.btnNext.setOnClickListener {
//            quotesviewmodel.randomGenerate()
//        }

        binding.btncalc.setOnClickListener {
            findNavController().navigate(R.id.action_thoughtFragment_to_calCFragment)
        }

        binding.btnListThought.setOnClickListener {
            findNavController().navigate(R.id.action_thoughtFragment_to_rvShowQuoteFragment)
        }

    }

}