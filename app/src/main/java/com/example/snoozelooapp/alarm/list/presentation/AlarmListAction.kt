package com.example.snoozelooapp.alarm.list.presentation

import com.example.snoozelooapp.alarm.list.domain.Weekday


/**
 * Created by AidenChang on 2025/7/21
 */
interface AlarmListAction

object AddAlarmClick: AlarmListAction
data class ToggleSwitchClick(val id: String): AlarmListAction
data class ToggleDayOfAlarm(val id: String, val day: Weekday): AlarmListAction
data class DeleteAlarmClick(val id: String): AlarmListAction