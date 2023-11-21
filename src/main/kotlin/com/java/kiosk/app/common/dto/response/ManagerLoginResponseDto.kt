package com.java.kiosk.app.common.dto.response

data class ManagerLoginResponseDto (
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)