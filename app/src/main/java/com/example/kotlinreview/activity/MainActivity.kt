package com.example.kotlinreview.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinreview.R
import com.example.kotlinreview.api.QuotesService
import com.example.kotlinreview.api.RetrofitHelper
import com.example.kotlinreview.models.QuotesModel
import com.example.kotlinreview.repositories.QuotesRepository
import com.example.kotlinreview.viewmodel.MainViewModel
import com.example.kotlinreview.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: QuotesAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = QuotesAdapter( mutableListOf()) // Initialize adapter with an empty list

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val quoteService = RetrofitHelper.getInstance().create(QuotesService::class.java)
        val repository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer { quotes ->
            // Update adapter data when new data is received

            Log.d("check", quotes.results.toString())

            adapter.submitList(quotes.results)
        })
    }
}