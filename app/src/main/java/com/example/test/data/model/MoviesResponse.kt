package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val results: List<Movie>,
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
)

