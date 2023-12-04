package com.java.kiosk.app.common.dto.response

data class SaleHeaderQueryResponseDto(
    val id: Int,
    val saleDttm: String,
    val totalQty: Int,
    val totalPrice: Int
)