package com.example.test.data.repoimpl

import com.example.test.data.model.MoviesResponse
import com.example.test.domain.repository.MoviesRepository
import com.example.test.network.service.NetworkService
import retrofit2.Response
import javax.inject.Inject

class MoviesRepImpl @Inject constructor(private val networkService: NetworkService) : MoviesRepository {
    override suspend fun getMovies(): Response<MoviesResponse> = networkService.getMovies()
}