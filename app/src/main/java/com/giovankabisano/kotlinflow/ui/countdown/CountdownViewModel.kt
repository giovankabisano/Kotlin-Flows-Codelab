package com.giovankabisano.kotlinflow.ui.countdown

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountdownViewModel : ViewModel() {

    private fun time(): Flow<Int> = flow {
        for (i in 10 downTo 1) {
            delay(1000)
            emit(i)
        }
    }

    val result: LiveData<Int> = time().asLiveData()

}