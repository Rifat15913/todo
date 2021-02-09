package com.evatix.test.todo.business.service

import com.evatix.test.todo.data.entity.User
import com.evatix.test.todo.data.repository.UserRepository
import com.evatix.test.todo.utils.DataUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.sql.Date
import java.util.*

@Service
class UserService(
    @Autowired
    private val repository: UserRepository
) {
    fun getAllUsers(): List<User> {
        return repository.findAll().toList()
    }

    fun getUser(id: Int): User {
        return repository.findByIdOrNull(id) ?: throw IllegalStateException(
            "User not found"
        )
    }

    fun addUser(
        userName: String,
        email: String,
        password: String,
    ): User {
        return repository.save(
            User(
                userName = userName,
                email = email,
                createdAt = Date(Calendar.getInstance().time.time),
                isActive = true,
                passwordHash = DataUtil.hashIntoSHA256(password)
            )
        )
    }

    fun updateUser(
        id: Int,
        userName: String,
        email: String,
        password: String,
    ): User {
        val user = getUser(id)

        return repository.save(
            user.apply {
                this.userName = userName
                this.email = email
                this.passwordHash = DataUtil.hashIntoSHA256(password)
            }
        )
    }

    fun deleteUser(
        id: Int,
    ) {
        repository.deleteById(id)
    }
}