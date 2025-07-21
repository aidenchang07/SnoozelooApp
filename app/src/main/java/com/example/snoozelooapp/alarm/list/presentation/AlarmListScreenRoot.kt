package com.example.snoozelooapp.alarm.list.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snoozelooapp.R
import com.example.snoozelooapp.alarm.list.domain.Weekday
import com.example.snoozelooapp.alarm.list.presentation.components.DateChip
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme
import com.example.snoozelooapp.core.extensions.noRippleClickable
import org.koin.androidx.compose.koinViewModel

/**
 * Created by AidenChang on 2025/7/15
 */
@Composable
fun AlarmListScreenRoot(
    viewModel: AlarmListViewModel = koinViewModel()
) {
    viewModel.getAlarmList() // todo: 測試用
    AlarmListScreen()
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AlarmListScreen(
    modifier: Modifier = Modifier
) {
    val topDp = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary,
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.noRippleClickable {
                        // 實作這邊功能
                        println("aiden inner Icon")
                    },
                    imageVector = Icons.Default.Add,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = null
                )
            }
        }
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AlarmItem() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                Text(
                    text = "Wake Up",
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = "10:00",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = "AM",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                Text(
                    text = "Alarm in 30min",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Switch(
                checked = false,
                onCheckedChange = {
                    // 實作click功能
                }
            )
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            DateChip(isSelected = true, weekday = Weekday.MONDAY)
            DateChip(isSelected = true, weekday = Weekday.TUESDAY)
            DateChip(isSelected = true, weekday = Weekday.WEDNESDAY)
            DateChip(isSelected = true, weekday = Weekday.THURSDAY)
            DateChip(isSelected = true, weekday = Weekday.FRIDAY)
            DateChip(isSelected = true, weekday = Weekday.SATURDAY)
            DateChip(isSelected = true, weekday = Weekday.SUNDAY)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Go to bed at 02:00AM to get 8h of sleep",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            IconButton(
                onClick = {
                    // 實作click功能
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    tint = Color.Red,
                    contentDescription = null
                )
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

@Preview(showBackground = true)
@Composable
private fun AlarmItemPreview() {
    SnoozelooAppTheme {
        AlarmItem()
    }
}