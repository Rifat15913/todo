package com.evatix.test.todo.data.response

import java.time.LocalDateTime

data class BadRequestErrorResponse(
    val title: String = "Bad Request",
    val message: String,
    val dateTime: LocalDateTime = LocalDateTime.now(),
)
