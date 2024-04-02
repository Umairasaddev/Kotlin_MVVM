package com.example.kotlinreview.api

import com.example.kotlinreview.models.QuotesModel
import com.example.kotlinreview.models.ResultsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {


    @GET("quotes")
    suspend fun getQuotes(@Query("page") page:Int):Response<QuotesModel>
}