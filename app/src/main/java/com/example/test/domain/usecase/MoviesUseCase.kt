package com.example.test.domain.usecase

import com.example.test.ViewState

interface MoviesUseCase {
    suspend fun getMovies(): ViewState<List<User>>
}