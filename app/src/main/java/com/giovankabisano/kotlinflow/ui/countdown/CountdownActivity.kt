package com.giovankabisano.kotlinflow.ui.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.giovankabisano.kotlinflow.R
import com.giovankabisano.kotlinflow.api.ApiHelperImpl
import com.giovankabisano.kotlinflow.api.RetrofitBuilder
import com.giovankabisano.kotlinflow.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_countdown.*
import kotlinx.coroutines.Job

class CountdownActivity : AppCompatActivity() {
    private lateinit var viewModel: CountdownViewModel
    private var locationUpdatesJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)
        setupViewModel()
    }

    override fun onStart() {
        super.onStart()
        viewModel.result.observe(this, {
            textCountdown.text = it.toString()
        })
    }

    override fun onStop() {
        locationUpdatesJob?.cancel()
        super.onStop()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(
                    RetrofitBuilder.apiService
                )
            )
        ).get(CountdownViewModel::class.java)
    }
}