package com.example.snoozelooapp.alarm.data

import com.example.snoozelooapp.alarm.domain.Weekday
import java.time.LocalTime
import java.util.UUID

/**
 * Created by AidenChang on 2025/7/21
 */
data class Alarm(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val triggerTime: LocalTime,
    val enable: Boolean,
    val repeatDays: Set<Weekday>,
    val volume: Int,
    val ringtoneUri: String,
    val vibrate: Boolean
)