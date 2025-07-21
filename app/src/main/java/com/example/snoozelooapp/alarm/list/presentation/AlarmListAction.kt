package com.example.snoozelooapp.alarm.list.presentation


/**
 * Created by AidenChang on 2025/7/21
 */
interface AlarmListAction

object AddAlarmClick: AlarmListAction
data class ToggleClick(val id: String): AlarmListAction
data class DeleteAlarmClick(val id: String): AlarmListAction