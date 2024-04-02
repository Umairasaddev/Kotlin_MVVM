package com.example.kotlinreview.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinreview.api.QuotesService
import com.example.kotlinreview.models.QuotesModel
import com.example.kotlinreview.models.ResultsModel

class QuotesRepository(private val quotesService: QuotesService) {

    private val quotesLiveData = MutableLiveData<QuotesModel>()
    val quotes: LiveData<QuotesModel>
        get() = quotesLiveData


    suspend fun getQuotes(page: Int) {
        val result = quotesService.getQuotes(page)
        if (result?.body() != null) {
            quotesLiveData.postValue(result.body())
        }

    }

}