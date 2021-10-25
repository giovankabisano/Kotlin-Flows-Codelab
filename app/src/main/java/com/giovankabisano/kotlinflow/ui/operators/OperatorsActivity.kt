package com.giovankabisano.kotlinflow.ui.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giovankabisano.kotlinflow.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class OperatorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operators)

        val flow = flow {
            for (i in 1..10) {
                println("Emitting $i")
                emit(i)
                delay(1000)
            }
        }

        GlobalScope.launch {
            println("Something")
            flow.map{
                it*it
            }.collect {
                println("Result $it")
            }
            println("HAHAHAHHA")
        }
    }
}