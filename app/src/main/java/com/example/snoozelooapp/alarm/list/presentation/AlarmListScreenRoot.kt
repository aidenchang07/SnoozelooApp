package com.example.snoozelooapp.alarm.list.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.snoozelooapp.R

/**
 * Created by AidenChang on 2025/7/15
 */
@Composable
fun AlarmListScreenRoot(
//    viewModel: AlarmListViewModel = koinViewModel()
) {
    AlarmListScreen()
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AlarmListScreen(
    modifier: Modifier = Modifier
) {
    val topDp = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // 有資料畫面
//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(top = topDp + 30.dp + 16.dp + 24.dp)
//            ) {
//                items(100) { index ->
//                    Text(text = "Alarms $index", style = MaterialTheme.typography.titleLarge)
//                }
//            }
            // 無資料畫面
            EmptyAlarmListContent()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f))
                    .padding(top = topDp + 16.dp, bottom = 24.dp),
            ) {
                Text(text = "Your Alarms", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}

@Composable
private fun EmptyAlarmListContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(R.drawable.alarm),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.empty_alarm_list_title),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}