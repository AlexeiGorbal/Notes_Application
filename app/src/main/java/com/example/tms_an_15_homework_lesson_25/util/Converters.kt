package com.example.tms_an_15_homework_lesson_25.util

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun formatDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun formatLongToDate(date: Long): Date {
        return Date(date)
    }
}