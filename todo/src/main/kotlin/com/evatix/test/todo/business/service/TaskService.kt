package com.evatix.test.todo.business.service

import com.evatix.test.todo.data.entity.Task
import com.evatix.test.todo.data.repository.TaskRepository
import com.evatix.test.todo.data.repository.UserRepository
import com.evatix.test.todo.utils.DateUtil
import com.evatix.test.todo.utils.toSqlDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TaskService(
    @Autowired
    private val taskRepository: TaskRepository,
    @Autowired
    private val userRepository: UserRepository
) {
    fun getAllTasks(): List<Task> {
        return taskRepository.findAll().toList()
    }

    fun getTask(id: Int): Task {
        return taskRepository.findByIdOrNull(id) ?: throw IllegalStateException(
            "Task not found"
        )
    }

    fun addTask(
        taskTitle: String,
        startAt: String,
        endAt: String,
        isWholeDay: Int,
        isCompleted: Int,
        completedAt: String?,
        description: String?,
        userId: Int,
    ): Task {
        val user = userRepository.findByIdOrNull(userId) ?: throw IllegalStateException(
            "User not found"
        )

        return taskRepository.save(
            Task(
                taskTitle = taskTitle,
                startAt = DateUtil.createDate(startAt).toSqlDate(),
                endAt = DateUtil.createDate(endAt).toSqlDate(),
                isWholeDay = isWholeDay == 1,
                isCompleted = isCompleted == 1,
                completedAt = if (completedAt != null)
                    DateUtil.createDate(completedAt).toSqlDate()
                else
                    null,
                description = description,
                user = user
            )
        )
    }

    fun updateTask(
        id: Int,
        taskTitle: String,
        startAt: String,
        endAt: String,
        isWholeDay: Int,
        isCompleted: Int,
        completedAt: String?,
        description: String?,
    ): Task {
        val task = getTask(id)

        return taskRepository.save(
            task.apply {
                this.taskTitle = taskTitle
                this.startAt = DateUtil.createDate(startAt).toSqlDate()
                this.endAt = DateUtil.createDate(endAt).toSqlDate()
                this.isWholeDay = isWholeDay == 1
                this.isCompleted = isCompleted == 1
                this.completedAt = if (completedAt != null)
                    DateUtil.createDate(completedAt).toSqlDate()
                else
                    null
                this.description = description
            }
        )
    }

    fun deleteTask(
        id: Int,
    ) {
        taskRepository.deleteById(id)
    }
}