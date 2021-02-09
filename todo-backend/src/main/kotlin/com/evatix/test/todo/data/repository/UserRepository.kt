package com.evatix.test.todo.data.repository

import com.evatix.test.todo.data.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Int>