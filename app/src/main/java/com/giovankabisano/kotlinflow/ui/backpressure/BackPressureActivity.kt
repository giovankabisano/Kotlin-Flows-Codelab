package com.giovankabisano.kotlinflow.ui.backpressure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giovankabisano.kotlinflow.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch

class BackPressureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_pressure)

        val flow = flow {
            for (i in 1..10) {
                emit("Hello World ${i}")
                delay(1000)
            }
        }

//        https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/buffer.html
        /**
         * Imejin UI perlu nge render / memproses data selama 2 detik.
         */
        GlobalScope.launch {
            flow.buffer().collect {
                println(it)
                delay(2000)
            }
        }
    }
}