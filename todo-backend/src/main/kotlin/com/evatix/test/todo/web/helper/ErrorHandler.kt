package com.evatix.test.todo.web.helper

import com.evatix.test.todo.data.response.BadRequestErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import kotlin.IllegalStateException

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(e: IllegalStateException): ResponseEntity<BadRequestErrorResponse> {
        return ResponseEntity
            .badRequest()
            .body(BadRequestErrorResponse(message = e.localizedMessage))
    }
}