package com.evatix.test.todo.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        fun createDate(dateString: String?): Date {
            return if (dateString != null) {
                try {
                    DATE_FORMAT.parse(dateString)
                } catch (e: ParseException) {
                    Date()
                }
            } else {
                Date()
            }
        }
    }
}