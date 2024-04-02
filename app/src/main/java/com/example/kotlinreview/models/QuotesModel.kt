package com.example.kotlinreview.models

data class QuotesModel(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultsModel>,
    val totalCount: Int,
    val totalPages: Int,
) {}
