package com.java.kiosk.app.common.dto.response

data class ProductQueryResponseDto (
    val id: Int,
    val name: String,
    val nameEnd: String,
    val price: Int
)