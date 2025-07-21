package com.example.snoozelooapp.alarm.list.presentation.di

import com.example.snoozelooapp.alarm.list.presentation.AlarmListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by AidenChang on 2025/7/21
 */
val alarmModule = module {
    viewModelOf(::AlarmListViewModel)
}