package com.dzdtech.primhesaplama.model

data class CallsResponse(
    val assignedTeam: String,
    val bankName: String,
    val dueDate: String,
    val id: Int,
    val itsmName: String,
    val itsmStatus: Int,
    val jiraItsmNumber: String,
    val userId: Int
)