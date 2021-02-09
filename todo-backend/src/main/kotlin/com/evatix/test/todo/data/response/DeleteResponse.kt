package com.evatix.test.todo.data.response

import java.time.LocalDateTime

data class DeleteResponse(
    val message: String = "Deleted",
    val dateTime: LocalDateTime = LocalDateTime.now(),
)
