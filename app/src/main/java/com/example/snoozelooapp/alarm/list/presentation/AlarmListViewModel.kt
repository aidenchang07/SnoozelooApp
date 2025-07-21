package com.example.snoozelooapp.alarm.list.presentation

import androidx.lifecycle.ViewModel
import com.example.snoozelooapp.alarm.list.data.Alarm
import com.example.snoozelooapp.alarm.list.domain.Weekday

/**
 * Created by AidenChang on 2025/7/15
 */
class AlarmListViewModel: ViewModel() {
    fun getAlarmList(): List<AlarmUi> {
        // todo: 以下測試用
        return mutableListOf(
            AlarmUi(
                Alarm(
                    name = "Wake Up1",
                    hour = 10,
                    minute = 0,
                    enable = true,
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
                    enable = true,
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
            )
        )
    }
}