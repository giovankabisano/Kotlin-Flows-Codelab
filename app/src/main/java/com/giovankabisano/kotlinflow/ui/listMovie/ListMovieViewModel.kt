package com.giovankabisano.kotlinflow.ui.listMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovankabisano.kotlinflow.api.ApiHelper
import com.giovankabisano.kotlinflow.local.DatabaseHelper
import com.giovankabisano.kotlinflow.model.ApiUser
import com.giovankabisano.kotlinflow.model.ResultsItem
import com.giovankabisano.kotlinflow.utils.Resource
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListMovieViewModel(
    private val apiHelper: ApiHelper
) : ViewModel() {

    private val movies = MutableLiveData<Resource<List<ResultsItem>>>()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {

            movies.postValue(Resource.loading(null))
            apiHelper.getMovies()
                .catch { e ->
                    movies.postValue(Resource.error(e.toString(), null))
                }
                .collect {
                    movies.postValue(Resource.success(it))
                }
        }
    }

    fun getMovies(): LiveData<Resource<List<ResultsItem>>> {
        return movies
    }

}