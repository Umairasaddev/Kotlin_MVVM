package com.example.kotlinreview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinreview.models.QuotesModel
import com.example.kotlinreview.models.ResultsModel
import com.example.kotlinreview.repositories.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuotesRepository):ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
//            repository ny live data main response lia from QuotesRepository or view model main pass kar dia
        }

    }

    val quotes:LiveData<QuotesModel>
        get() = repository.quotes
}