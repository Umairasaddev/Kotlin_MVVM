package com.example.kotlinreview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinreview.repositories.QuotesRepository


//when we use parametrized constructor in view model
class MainViewModelFactory(private val repository:QuotesRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}