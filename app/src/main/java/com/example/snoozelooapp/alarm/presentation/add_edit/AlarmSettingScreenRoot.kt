package com.example.snoozelooapp.alarm.presentation.add_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snoozelooapp.R
import com.example.snoozelooapp.alarm.presentation.components.AppBar
import com.example.snoozelooapp.core.components.AlarmItemContainer
import com.example.snoozelooapp.core.components.InputTimeTextField
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme

/**
 * Created by AidenChang on 2025/7/22
 */
@Composable
fun AlarmSettingScreenRoot() {
    AlarmSettingScreen()
}

@Composable
private fun AlarmSettingScreen(
    modifier: Modifier = Modifier
) {
    val topDp = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val bottomDp = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = topDp + 30.dp + 16.dp + 24.dp,
                bottom = bottomDp + 16.dp,
                start = 16.dp, end = 16.dp
            )
            .background(color = MaterialTheme.colorScheme.surface),
    ) {
        AppBar(
            onLeftClick = {},
            onRightClick = {},
            buttonText = stringResource(R.string.app_bar_save)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // 時間輸入框
        AlarmItemContainer {
            Row(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InputTimeTextField(
                    modifier = Modifier.weight(1f),
                    text = "" // TODO: 待加入data model
                )
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = ":",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 52.sp
                )
                InputTimeTextField(
                    modifier = Modifier.weight(1f),
                    text = "" // TODO: 待加入data model
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmSettingScreenPreview() {
    SnoozelooAppTheme {
        AlarmSettingScreen()
    }
}