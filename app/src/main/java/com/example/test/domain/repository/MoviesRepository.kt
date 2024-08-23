package com.example.test.domain.repository

import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovies(): Response<List<User>>
}