package com.example.snoozelooapp

import android.app.Application
import com.example.snoozelooapp.alarm.list.presentation.di.alarmModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by AidenChang on 2025/7/15
 */
class SnoozelooApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SnoozelooApp)
            modules(
                alarmModule
            )
        }
    }
}