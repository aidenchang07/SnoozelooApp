package com.example.snoozelooapp.alarm.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snoozelooapp.R
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme
import com.example.snoozelooapp.core.extensions.appButtonColors

/**
 * Created by AidenChang on 2025/7/22
 */
@Composable
fun AppBar(
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(32.dp)
                .clickable(
                    role = Role.Button,
                    onClick = onLeftClick
                ),
            painter = painterResource(R.drawable.subtract),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null
        )
        Button(
            modifier = Modifier.clip(RoundedCornerShape(30.dp)),
            colors = appButtonColors(),
            enabled = false,
            onClick = onRightClick
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppBarPreview() {
    SnoozelooAppTheme {
        AppBar(
            onLeftClick = {},
            onRightClick = {},
            buttonText = "Save"
        )
    }
}