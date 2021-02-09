package com.evatix.test.todo.data.entity

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "User")
data class User(
    @Id
    @Column(name = "UserID")
    @SequenceGenerator(
        name = USER_SEQUENCE,
        sequenceName = USER_SEQUENCE,
        initialValue = 1,
        allocationSize = 1,
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_SEQUENCE)
    val id: Int? = null,

    @Column(name = "UserName")
    var userName: String? = null,

    @Column(name = "Email")
    var email: String,

    @Column(name = "PasswordHash")
    var passwordHash: String,

    @Column(name = "CreatedAt")
    var createdAt: Date,

    @Column(name = "IsActive")
    var isActive: Boolean = false,
) {
    companion object {
        const val USER_SEQUENCE = "USER_SEQUENCE"
    }
}
