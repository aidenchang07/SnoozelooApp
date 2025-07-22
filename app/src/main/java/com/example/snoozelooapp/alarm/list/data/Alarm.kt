package com.example.snoozelooapp.alarm.list.data

import com.example.snoozelooapp.alarm.list.domain.Weekday
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