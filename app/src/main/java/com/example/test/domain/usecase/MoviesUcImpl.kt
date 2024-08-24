package com.example.test.domain.usecase

import com.example.test.ViewState
import com.example.test.data.model.Movie
import com.example.test.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesUcImpl @Inject constructor(private val repository: MoviesRepository) : MoviesUseCase {
    override suspend fun getMovies(): ViewState<List<Movie>> {
        val response = repository.getMovies()
        return if (response.isSuccessful && response.body()?.results != null) {
            ViewState.SUCCESS(response.body()?.results)
        } else {
            ViewState.ERROR(response.errorBody().toString())
        }
    }
}