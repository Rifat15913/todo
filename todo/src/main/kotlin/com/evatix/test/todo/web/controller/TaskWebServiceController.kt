package com.evatix.test.todo.web.controller

import com.evatix.test.todo.business.service.TaskService
import com.evatix.test.todo.data.entity.Task
import com.evatix.test.todo.data.response.DeleteResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api")
class TaskWebServiceController(
    @Autowired
    private val service: TaskService
) {
    @GetMapping("/tasks")
    fun getAllTasks(): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(
            service.getAllTasks()
        )
    }

    @GetMapping("/task/{id}")
    fun getTask(@PathVariable id: Int): ResponseEntity<Task> {
        return ResponseEntity.ok(service.getTask(id))
    }

    @PostMapping("/task")
    fun addTask(
        @RequestParam(value = "task_title", required = true)
        taskTitle: String,
        @RequestParam(value = "start_at", required = true)
        startAt: String,
        @RequestParam(value = "end_at", required = true)
        endAt: String,
        @RequestParam(value = "is_whole_day", required = false)
        isWholeDay: Int?,
        @RequestParam(value = "is_completed", required = false)
        isCompleted: Int?,
        @RequestParam(value = "completed_at", required = false)
        completedAt: String? = null,
        @RequestParam(value = "description", required = false)
        description: String? = null,
        @RequestParam(value = "user_id", required = true)
        userId: Int,
    ): ResponseEntity<Task> {

        val task: Task = service.addTask(
            taskTitle, startAt, endAt, isWholeDay ?: 0, isCompleted ?: 0,
            completedAt, description, userId
        )

        return ResponseEntity
            .created(URI.create("/task".plus("/${task.id}")))
            .body(task)
    }

    @PutMapping("/task/{id}")
    fun updateTask(
        @PathVariable(value = "id", required = true)
        id: Int,
        @RequestParam(value = "task_title", required = true)
        taskTitle: String,
        @RequestParam(value = "start_at", required = true)
        startAt: String,
        @RequestParam(value = "end_at", required = true)
        endAt: String,
        @RequestParam(value = "is_whole_day", required = false)
        isWholeDay: Int?,
        @RequestParam(value = "is_completed", required = false)
        isCompleted: Int?,
        @RequestParam(value = "completed_at", required = false)
        completedAt: String? = null,
        @RequestParam(value = "description", required = false)
        description: String? = null,
    ): ResponseEntity<Task> {
        return ResponseEntity.ok(
            service.updateTask(
                id, taskTitle, startAt, endAt, isWholeDay ?: 0, isCompleted ?: 0,
                completedAt, description
            )
        )
    }

    @DeleteMapping("/task/{id}")
    fun deleteTask(
        @PathVariable(value = "id", required = true)
        id: Int,
    ): ResponseEntity<DeleteResponse> {
        service.deleteTask(id)
        return ResponseEntity.ok(DeleteResponse())
    }
}