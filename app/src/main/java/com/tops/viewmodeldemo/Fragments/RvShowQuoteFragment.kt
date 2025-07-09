package com.tops.viewmodeldemo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tops.viewmodeldemo.R
import com.tops.viewmodeldemo.ViewModels.QuotesViewModel
import com.tops.viewmodeldemo.adapter.MyAdapter
import com.tops.viewmodeldemo.databinding.FragmentRvShowQuoteBinding
import com.tops.viewmodeldemo.model.QuotesData

class RvShowQuoteFragment : Fragment() {

    private val quotesviewmodel : QuotesViewModel by viewModels()
    private lateinit var binding: FragmentRvShowQuoteBinding
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRvShowQuoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MyAdapter(emptyList())
        binding.tvQuotes.layoutManager = LinearLayoutManager(requireActivity())
        binding.tvQuotes.adapter = adapter

        quotesviewmodel.quotes.observe(viewLifecycleOwner,  Observer{
                quoteList ->
            adapter.updateData(quoteList)
        })

        binding.btnGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_rvShowQuoteFragment_to_thoughtFragment)
        }
    }
}