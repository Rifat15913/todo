package com.todo.app.main.data.local.model

data class DashboardBannerItem(
    val id: Int,
    val type: Int,
    val title: String,
    val subTitle: String?,
    val buttonText: String?,
    val image: Any?
)