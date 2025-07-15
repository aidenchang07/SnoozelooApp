package com.example.snoozelooapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Created by AidenChang on 2025/7/15
 */
class SnoozelooApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
}