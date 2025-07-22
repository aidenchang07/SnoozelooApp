package com.example.snoozelooapp.alarm.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snoozelooapp.alarm.list.data.Alarm
import com.example.snoozelooapp.alarm.list.domain.Weekday
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by AidenChang on 2025/7/15
 */
class AlarmListViewModel: ViewModel() {
    private val _alarmList = MutableStateFlow<List<AlarmUi>>(emptyList())
    val alarmList: StateFlow<List<AlarmUi>> = _alarmList.asStateFlow()

    init {
        getAlarmList()
    }

    fun getAlarmList() {
        // todo: 以下測試用
        viewModelScope.launch {
            _alarmList.update {
                listOf(
                    AlarmUi(
                        Alarm(
                            name = "Wake Up1",
                            hour = 10,
                            minute = 0,
                            enable = false,
                            repeatDays = setOf(Weekday.MONDAY, Weekday.TUESDAY),
                            volume = 4,
                            ringtoneUri = "",
                            vibrate = false
                        )
                    ),
                    AlarmUi(
                        Alarm(
                            name = "Wake Up2",
                            hour = 12,
                            minute = 10,
                            enable = false,
                            repeatDays = setOf(Weekday.MONDAY, Weekday.TUESDAY, Weekday.WEDNESDAY),
                            volume = 6,
                            ringtoneUri = "",
                            vibrate = false
                        )
                    ),
                    AlarmUi(
                        Alarm(
                            name = "Wake Up3",
                            hour = 16,
                            minute = 47,
                            enable = true,
                            repeatDays = setOf(Weekday.TUESDAY),
                            volume = 8,
                            ringtoneUri = "",
                            vibrate = false
                        )
                    ),
                    AlarmUi(
                        Alarm(
                            name = "Wake Up4",
                            hour = 16,
                            minute = 47,
                            enable = true,
                            repeatDays = setOf(Weekday.TUESDAY),
                            volume = 8,
                            ringtoneUri = "",
                            vibrate = false
                        )
                    )
                )
            }
        }
    }

    fun handleAction(action: AlarmListAction) {
        when (action) {
            is AddAlarmClick -> {
                // todo: 新增鬧鐘
            }
            is ToggleClick -> {
                // 切換鬧鐘狀態
                _alarmList.update { old ->
                    old.map {
                        if (it.alarm.id == action.id) {
                            it.copy(
                                alarm = it.alarm.copy(
                                    enable = !it.alarm.enable
                                )
                            )
                        } else {
                            it
                        }
                    }
                }
            }
            is ToggleDayOfAlarm -> {
                // 切換選擇鬧鐘星期
                _alarmList.update { oldAlarmList ->
                    oldAlarmList.map { alarmUi ->
                        if (alarmUi.alarm.id == action.id) {
                            // 找到要切換的那筆，copy 一份並 toggle day
                            val newDays = alarmUi.alarm.repeatDays.toMutableSet().apply {
                                if (contains(action.day)) remove(action.day)
                                else add(action.day)
                            }
                            alarmUi.copy(alarm = alarmUi.alarm.copy(repeatDays = newDays))
                        } else alarmUi
                    }
                }
            }
            is DeleteAlarmClick -> {
                // 刪除鬧鐘，只保留 id 不等於 action.id 的 item
                _alarmList.update { old ->
                    old.filterNot { it.alarm.id == action.id }
                }
            }
        }
    }
}