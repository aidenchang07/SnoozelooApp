package com.example.snoozelooapp.alarm.list.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
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
    val state = viewModel.alarmList.collectAsState()
    AlarmListScreen(
        state = state.value,
        onAction = { action ->
            viewModel.handleAction(action)
        }
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AlarmListScreen(
    state: List<AlarmUi>,
    onAction: (AlarmListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val topDp = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val bottomDp = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    println("aiden bottomDp: $bottomDp")
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
                        onAction(AddAlarmClick)
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
            if (state.isNotEmpty()) {
                // 有資料畫面
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        top = topDp + 30.dp + 16.dp + 24.dp,
                        bottom = bottomDp + 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(state) {
                        AlarmItem(
                            alarmUi = it,
                            onAction = onAction
                        )
                    }
                }
            } else {
                // 無資料畫面
                EmptyAlarmListContent()
            }

            // 首頁的title
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f))
                    .padding(top = topDp + 16.dp, bottom = 24.dp),
            ) {
                Text(
                    text = stringResource(R.string.alarm_list_title),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AlarmItem(
    alarmUi: AlarmUi,
    onAction: (AlarmListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                Text(
                    text = alarmUi.alarm.name.ifBlank { "Alarm" },
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = alarmUi.alarm.hour.toString(), // TODO: 待調整用LocalTime
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(
                        modifier = Modifier.alignByBaseline(),
                        text = "AM", // TODO: 待調整用LocalTime判斷給出上下午
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                if (alarmUi.alarm.enable) {
                    Text(
                        text = "Alarm in 30min",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            Switch(
                checked = alarmUi.alarm.enable,
                onCheckedChange = {
                    onAction(ToggleClick(alarmUi.alarm.id))
                }
            )
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Weekday.entries.forEach { day ->
                DateChip(
                    isSelected = alarmUi.alarm.repeatDays.contains(day),
                    weekday = day
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // todo: 待調整判斷顯示，時間夠近再顯示
            Text(
                text = "Go to bed at 02:00AM to get 8h of sleep",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            IconButton(
                onClick = {
                    onAction(DeleteAlarmClick(alarmUi.alarm.id))
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
                text = stringResource(R.string.alarm_list_empty_desc),
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
        AlarmItem(
            AlarmUi.default(),
            onAction = {}
        )
    }
}