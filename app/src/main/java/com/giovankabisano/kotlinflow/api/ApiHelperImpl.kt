package com.giovankabisano.kotlinflow.api

import kotlinx.coroutines.flow.flow
import java.lang.Exception

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override fun getMovies() = flow {
        val a = apiService.getMovies()
        emit(a.results)
    }

}