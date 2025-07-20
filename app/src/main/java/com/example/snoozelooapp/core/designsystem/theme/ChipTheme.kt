package com.example.snoozelooapp.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Created by AidenChang on 2025/7/21
 */
@Immutable
data class ChipTheme(
    val selectedContainerColor: Color,
    val selectedLabelColor: Color,
    val containerColor: Color,
    val labelColor: Color,
)

val LocalChipTheme = staticCompositionLocalOf {
    ChipTheme(
        selectedContainerColor = blue,
        selectedLabelColor = Color.White,
        containerColor = periwinkle,
        labelColor = obsidianBlue,
    )
}