package com.evatix.test.todo.data.entity

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "Task")
data class Task(
    @Id
    @Column(name = "TaskID")
    @SequenceGenerator(
        name = TASK_SEQUENCE,
        sequenceName = TASK_SEQUENCE,
        initialValue = 1,
        allocationSize = 1,
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TASK_SEQUENCE)
    val id: Int? = null,

    @Column(name = "TaskTitle")
    var taskTitle: String? = null,

    @Column(name = "StartAt")
    var startAt: Date?,

    @Column(name = "EndAt")
    var endAt: Date?,

    @Column(name = "IsWholeDay")
    var isWholeDay: Boolean = false,

    @Column(name = "IsCompleted")
    var isCompleted: Boolean = false,

    @Column(name = "CompletedAt")
    var completedAt: Date?,

    @Column(name = "Description")
    var description: String?,

    @ManyToOne
    @JoinColumn(name="UserIDFK")
    var user: User,
){
    companion object {
        const val TASK_SEQUENCE = "TASK_SEQUENCE"
    }
}

