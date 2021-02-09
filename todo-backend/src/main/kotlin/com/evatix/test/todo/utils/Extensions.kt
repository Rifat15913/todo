package com.evatix.test.todo.utils

fun java.util.Date.toSqlDate(): java.sql.Date {
    return java.sql.Date(this.time)
}