package com.jaydeepw.periodicwork.android

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.WorkManager
import com.jaydeepw.periodicwork.android.ui.theme.PeriodicWorkTheme
import androidx.work.PeriodicWorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val btnRun = findViewById<Button>(R.id.btnRun)
        btnRun.setOnClickListener(View.OnClickListener {
            Log.i("Main", "Btn clicked")
            // Create a periodic work request
            val myPeriodicWorkRequest =
                PeriodicWorkRequest.Builder(MyWorker::class.java, 30, TimeUnit.SECONDS).build()

            // Enqueue the periodic work request
            WorkManager.getInstance(this).enqueue(myPeriodicWorkRequest)
        })

    }
}