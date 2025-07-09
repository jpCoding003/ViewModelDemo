package com.tops.viewmodeldemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tops.viewmodeldemo.databinding.RowQuotesItemBinding
import com.tops.viewmodeldemo.model.QuotesData


class MyAdapter(var quotes: List<QuotesData>) : RecyclerView.Adapter<MyAdapter.QuotesShowViewHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuotesShowViewHolder {
       val binding = RowQuotesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuotesShowViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: QuotesShowViewHolder,
        position: Int
    ) {
        val quote = quotes[position]
        holder.binding.tvQuotes.setText(quote.quotes)
    }

    override fun getItemCount(): Int = quotes.size

    fun updateData(newQuotes: List<QuotesData>) {
        quotes = newQuotes
        notifyDataSetChanged()
    }

    class QuotesShowViewHolder(val binding: RowQuotesItemBinding): RecyclerView.ViewHolder(binding.root)
}