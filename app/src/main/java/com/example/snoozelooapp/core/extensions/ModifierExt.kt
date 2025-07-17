package com.example.snoozelooapp.core.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

/**
 * Created by AidenChang on 2025/7/17
 */
/**
 * Modifier 擴充：提供無波紋點擊效果 (no ripple)，並且使用 inline 與 composed 以最佳化效能和正確的 remember 行為。
 *
 * 用法示例：
 * ```kotlin
 * Box(
 *   Modifier
 *     .size(48.dp)
 *     .background(Color.Blue)
 *     .noRippleClickable {
 *       // 點擊事件
 *       println("Box clicked without ripple!")
 *     }
 * )
 * ```
 *
 * @param onClick 點擊回調，不會觸發波紋效果
 * @return 加上無波紋點擊功能後的 Modifier
 */
inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {
    // 直接回傳一個 clickable，並且完全無 ripple
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}