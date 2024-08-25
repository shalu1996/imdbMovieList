package com.example.test.domain.repository

import com.example.test.data.model.MoviesResponse
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovies(): Response<MoviesResponse>
}