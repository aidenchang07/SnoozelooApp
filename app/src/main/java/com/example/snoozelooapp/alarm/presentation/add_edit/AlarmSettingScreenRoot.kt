package com.example.snoozelooapp.alarm.presentation.add_edit

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme

/**
 * Created by AidenChang on 2025/7/22
 */
@Composable
fun AlarmSettingScreenRoot() {
    AlarmSettingScreen()
}

@Composable
private fun AlarmSettingScreen() {
    
}

@Preview(showBackground = true)
@Composable
private fun AlarmSettingScreenPreview() {
    SnoozelooAppTheme {
        AlarmSettingScreen()
    }
}