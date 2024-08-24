package com.example.test.domain.usecase

import com.example.test.ViewState
import com.example.test.data.model.Movie

interface MoviesUseCase {
    suspend fun getMovies(): ViewState<List<Movie>>
}