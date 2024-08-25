package com.example.test.network.service

import com.example.test.data.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.themoviedb.org/3/trending/movie/week?language=en-US&api_key=0ae4cccc26cdb16620b2b74ca5c18d45
//eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYWU0Y2NjYzI2Y2RiMTY2MjBiMmI3NGNhNWMxOGQ0NSIsIm5iZiI6MTcyNDQxODM4MC42MjgyMzYsInN1YiI6IjY2Yzg3OWQyZGNhZDc5M2I0MzNjZTAyOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Gmn6aKl7n3SDnZz71iSQrppVM2DSK8qMLrQJ5ZKaPMs
//Retrofit has inbuilt support for suspend, internally it calls call.enqueue()
interface NetworkService {
    @GET("movie/week")
    suspend fun getMovies(
        @Query("language") language: String = "en-US",
        @Query("api_key") apiKey: String = "0ae4cccc26cdb16620b2b74ca5c18d45"
    ): Response<MoviesResponse>
}