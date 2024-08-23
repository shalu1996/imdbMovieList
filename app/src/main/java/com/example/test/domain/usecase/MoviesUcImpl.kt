package com.example.test.domain.usecase

import com.example.test.ViewState
import com.example.test.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesUcImpl @Inject constructor(private val repository: MoviesRepository) : MoviesUseCase {
    override suspend fun getMovies(): ViewState<List<User>> {
        val response = repository.getMovies()
        return if (response.isSuccessful) {
            ViewState.SUCCESS(response.body())
        } else {
            ViewState.ERROR(response.errorBody().toString())
        }
    }
}