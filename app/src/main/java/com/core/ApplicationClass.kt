package com.core

import android.app.Activity
import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
//import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ApplicationClass: Application() {

    private var currentActivity: Activity? = null

//    @Inject
//    var workerFactory: HiltWorkerFactory? = null

//    @Override
//    override fun getWorkManagerConfiguration(): Configuration {
//        return Configuration.Builder()
//            .setWorkerFactory(workerFactory!!)
//            .build()
//    }

    @Override
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {

//        FirebaseApp.initializeApp(this)
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
    }

    private val activityLifecycleCallbacks: BaseActivityLifecycleCallbacks =
        object : BaseActivityLifecycleCallbacks() {
            override fun onActivityResumed(activity: Activity) {
                currentActivity = activity
            }
        }
}