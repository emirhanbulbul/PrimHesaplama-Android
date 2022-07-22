package com.dzdtech.primhesaplama.model

data class DashboardResponse(
    val userId:Int,
    val toplamPrimHakedis: Int,
    val itsmPrimHakedis: Int,
    val projectPrimHakedis: Int,
    val projectAndItsmCount: Int)