package com.example.kotlinreview.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinreview.R
import com.example.kotlinreview.models.ResultsModel

class QuotesAdapter(private var quotes: List<ResultsModel>) :
    RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

//    private var quotesa: List<ResultsModel> = listOf() // Initialize with an empty list

    fun submitList(newList: List<ResultsModel>) {
        quotes = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author: TextView = itemView.findViewById(R.id.authorTV)
        val content: TextView = itemView.findViewById(R.id.contentTV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.quotes_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val quote = quotes[position]


        holder.author.text = quote.author
        holder.content.text = quote.content

    }


}


