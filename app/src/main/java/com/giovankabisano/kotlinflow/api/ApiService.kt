package com.giovankabisano.kotlinflow.api

import com.giovankabisano.kotlinflow.model.MovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("popular?api_key=6a0ff284c12c6a9522dfe9623ed5c8c7&language=en-US&page=1")
    suspend fun getMovies(): MovieResponse

}