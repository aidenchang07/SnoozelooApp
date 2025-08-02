package com.example.snoozelooapp.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme

/**
 * Created by AidenChang on 2025/8/2
 */
@Composable
fun AlarmItemContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmItemContainerPreview() {
    SnoozelooAppTheme {
        AlarmItemContainer(
            content = {}
        )
    }
}