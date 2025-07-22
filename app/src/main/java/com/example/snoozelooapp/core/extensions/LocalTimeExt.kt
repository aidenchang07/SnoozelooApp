package com.example.snoozelooapp.core.extensions

import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * Created by AidenChang on 2025/7/22
 */

/**
 * 將 [LocalTime] 依照指定的 pattern 轉成字串，預設為 "HH:mm"。
 *
 * @param pattern Java DateTimeFormatter 風格的時間格式字串，如 "HH:mm", "hh:mm a", "HH:mm:ss"…
 * @return 格式化後的時間字串
 */
fun LocalTime.toFormattedString(pattern: String = "HH:mm"): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(formatter)
}

/**
 * 將 [LocalTime] 直接用傳入的 [DateTimeFormatter] 轉成字串。
 *
 * @param formatter 已預先建立好的 DateTimeFormatter
 * @return 格式化後的時間字串
 */
fun LocalTime.toFormattedString(formatter: DateTimeFormatter): String =
    this.format(formatter)