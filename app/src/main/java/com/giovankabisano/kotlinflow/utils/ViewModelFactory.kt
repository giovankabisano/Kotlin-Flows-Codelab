package com.giovankabisano.kotlinflow.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.giovankabisano.kotlinflow.ui.countdown.CountdownViewModel
import com.giovankabisano.kotlinflow.ui.listMovie.ListMovieViewModel
import com.giovankabisano.kotlinflow.api.ApiHelper

class ViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListMovieViewModel::class.java)) {
            return ListMovieViewModel(apiHelper) as T
        }
        else if (modelClass.isAssignableFrom(CountdownViewModel::class.java)) {
            return CountdownViewModel() as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}