package com.example.snoozelooapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.snoozelooapp.alarm.list.presentation.AlarmListScreenRoot
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnoozelooAppTheme {
                AlarmListScreenRoot()
            }
        }
    }
}