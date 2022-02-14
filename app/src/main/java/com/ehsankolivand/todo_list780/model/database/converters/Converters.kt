package com.ehsankolivand.todo_list780.model.database.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime

/**
 * Google Say :
 * Sometimes, you need your app to store a custom data type in a
 * single database column. You support custom types by providing type converters
 * */
class Converters {

    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? {
        return if (dateString == null) {
            null
        } else {
            LocalDateTime.parse(dateString)
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDateTime?): String? {
        return date?.toString()
    }
}