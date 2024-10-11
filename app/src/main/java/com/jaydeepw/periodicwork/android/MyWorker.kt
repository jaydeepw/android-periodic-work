package com.jaydeepw.periodicwork.android

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import android.util.Log

class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        // Your task code goes here
        Log.d("MyWorker", "Work is being executed")

        // Return the result of the task
        return Result.success()  // or Result.failure() or Result.retry()
    }
}
