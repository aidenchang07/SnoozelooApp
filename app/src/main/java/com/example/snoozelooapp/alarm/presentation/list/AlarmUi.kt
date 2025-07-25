package com.example.snoozelooapp.alarm.presentation.list

import com.example.snoozelooapp.alarm.data.Alarm
import com.example.snoozelooapp.alarm.domain.Weekday
import java.time.LocalTime
import java.util.UUID

/**
 * Created by AidenChang on 2025/7/21
 */
data class AlarmUi(
    val alarm: Alarm
) {
    companion object {
        /** 回傳一個預設的 AlarmUi 範例物件 */
        fun default(): AlarmUi = AlarmUi(
            Alarm(
                // 隨機產生 id，也可以自己指定
                id = UUID.randomUUID().toString(),
                name = "預設鬧鐘",
                triggerTime = LocalTime.of(7, 10),
                enable = true,
                repeatDays = setOf(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY),
                volume = 5,
                ringtoneUri = "",
                vibrate = true
            )
        )
    }
}
