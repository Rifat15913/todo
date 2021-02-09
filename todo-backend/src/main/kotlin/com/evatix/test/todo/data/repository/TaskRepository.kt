package com.evatix.test.todo.data.repository

import com.evatix.test.todo.data.entity.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Int>