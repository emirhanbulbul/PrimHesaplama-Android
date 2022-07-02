package com.dzdtech.primhesaplama.model

data class ProjectsResponse(
    val assignedTeam: String,
    val bankName: String,
    val dueDate: String,
    val id: Int,
    val jiraProjectNumber: String,
    val projectName: String,
    val projectStatus: Int,
    val totalManDay: Int,
    val userId: Int,
    val userManDay: Int
)