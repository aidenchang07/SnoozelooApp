package com.example.snoozelooapp.core.extensions

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.snoozelooapp.core.designsystem.theme.surfaceDeep

/**
 * Created by AidenChang on 2025/7/23
 */
@Composable
fun appButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.onPrimary,
    disabledContainerColor = surfaceDeep,
    disabledContentColor = MaterialTheme.colorScheme.onPrimary,
)