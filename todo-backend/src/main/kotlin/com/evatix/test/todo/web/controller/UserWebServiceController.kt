package com.evatix.test.todo.web.controller

import com.evatix.test.todo.business.service.UserService
import com.evatix.test.todo.data.entity.User
import com.evatix.test.todo.data.response.DeleteResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api")
class UserWebServiceController(
    @Autowired
    private val service: UserService
) {
    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(
            service.getAllUsers()
        )
    }

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<User> {
        return ResponseEntity.ok(service.getUser(id))
    }

    @PostMapping("/user")
    fun addUser(
        @RequestParam(value = "user_name", required = true)
        userName: String,
        @RequestParam(value = "email", required = true)
        email: String,
        @RequestParam(value = "password", required = true)
        password: String,
        @RequestParam(value = "confirm_password", required = true)
        confirmPassword: String,
    ): ResponseEntity<User> {
        val user: User

        if (password == confirmPassword) {
            user = service.addUser(userName, email, password)
        } else {
            throw java.lang.IllegalStateException("Passwords do not match")
        }

        return ResponseEntity
            .created(URI.create("/user".plus("/${user.id}")))
            .body(user)
    }

    @PutMapping("/user/{id}")
    fun updateUser(
        @PathVariable(value = "id", required = true)
        id: Int,
        @RequestParam(value = "user_name", required = true)
        userName: String,
        @RequestParam(value = "email", required = true)
        email: String,
        @RequestParam(value = "password", required = true)
        password: String,
        @RequestParam(value = "confirm_password", required = true)
        confirmPassword: String,
    ): ResponseEntity<User> {
        return ResponseEntity.ok(
            service.updateUser(id, userName, email, password)
        )
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(
        @PathVariable(value = "id", required = true)
        id: Int,
    ): ResponseEntity<DeleteResponse> {
        service.deleteUser(id)
        return ResponseEntity.ok(DeleteResponse())
    }
}