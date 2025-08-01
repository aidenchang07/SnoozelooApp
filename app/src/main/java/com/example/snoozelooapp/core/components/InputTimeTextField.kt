package com.example.snoozelooapp.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snoozelooapp.core.designsystem.theme.SnoozelooAppTheme

/**
 * Created by AidenChang on 2025/7/25
 */
@Composable
fun InputTimeTextField(
    text: String,
    modifier: Modifier = Modifier,
    emptyText: String = "00",
    onValueChange: (String) -> Unit = {},
    maxLine: Int = 1,
    maxCharacter: Int = 2
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    val textStyle = MaterialTheme.typography.displayMedium.copy(
        fontSize = 52.sp,
        lineHeight = 62.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary
    )

    BasicTextField(
        value = text,
        onValueChange = { text ->
            if (text.length <= maxCharacter) {
                onValueChange(text)
            }
        },
        textStyle = textStyle,
        maxLines = maxLine,
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.surface)
            .onFocusChanged { isFocused = it.isFocused }
    ) { innerTextField ->
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (text.isBlank() && !isFocused) {
                Text(
                    text = emptyText,
                    style = textStyle,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            innerTextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputTimeTextFieldPreview() {
    SnoozelooAppTheme {
        InputTimeTextField(
            text = ""
        )
    }
}