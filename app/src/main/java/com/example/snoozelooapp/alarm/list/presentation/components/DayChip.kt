package com.example.snoozelooapp.alarm.list.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snoozelooapp.alarm.list.domain.Weekday
import com.example.snoozelooapp.core.designsystem.theme.LocalChipTheme
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme

/**
 * Created by AidenChang on 2025/7/20
 */
@Composable
fun DateChip(
    weekday: Weekday,
    isSelected: Boolean,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    selectedContainerColor: Color = LocalChipTheme.current.selectedContainerColor,
    selectedLabelColor: Color = LocalChipTheme.current.selectedLabelColor,
    containerColor: Color = LocalChipTheme.current.containerColor,
    labelColor: Color = LocalChipTheme.current.labelColor
) {
    FilterChip(
        modifier = modifier,
        selected = isSelected,
        shape = RoundedCornerShape(38.dp),
        border = BorderStroke(0.dp, Color.Transparent),
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = selectedContainerColor,
            selectedLabelColor = selectedLabelColor,
            containerColor = containerColor,
            labelColor = labelColor
        ),
        onClick = onClick,
        label = {
            Text(
                text = weekday.abbr,
                style = MaterialTheme.typography.labelSmall,
                fontSize = 12.sp
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DateChipPreview() {
    SnoozelooAppTheme {
        DateChip(
            isSelected = false,
            weekday = Weekday.MONDAY
        )
    }
}