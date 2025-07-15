package com.example.snoozelooapp.alarm.list.presentation

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by AidenChang on 2025/7/15
 */
@Composable
fun AlarmListScreenRoot(
    viewModel: AlarmListViewModel = koinViewModel()
) {
    AlarmListScreen()
}

@Composable
fun AlarmListScreen() {

}