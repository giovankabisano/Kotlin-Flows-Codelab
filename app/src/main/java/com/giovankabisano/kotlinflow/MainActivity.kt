package com.giovankabisano.kotlinflow

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.giovankabisano.kotlinflow.ui.backpressure.BackPressureActivity
import com.giovankabisano.kotlinflow.ui.countdown.CountdownActivity
import com.giovankabisano.kotlinflow.ui.listMovie.ListMovieActivity
import com.giovankabisano.kotlinflow.ui.operators.OperatorsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupClicks()
    }

    private fun setupClicks() {
        operatorsButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, OperatorsActivity::class.java))
        }
        backPressureButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, BackPressureActivity::class.java))
        }
        countdownButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, CountdownActivity::class.java))
        }
        listMovieButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListMovieActivity::class.java))
        }
    }
}