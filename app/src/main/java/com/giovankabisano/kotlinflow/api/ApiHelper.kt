package com.giovankabisano.kotlinflow.api

import com.giovankabisano.kotlinflow.model.ResultsItem
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    fun getMovies(): Flow<List<ResultsItem>>

}