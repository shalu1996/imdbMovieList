package com.example.test.network.service

import retrofit2.Response
import retrofit2.http.GET

//Retrofit has inbuilt support for suspend, internally it calls call.enqueue()
interface NetworkService {
    @GET("/users")
    suspend fun getMovies():Response<List<User>>
}