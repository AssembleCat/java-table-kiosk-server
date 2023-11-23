package com.java.kiosk.app.common.dto.response

import java.time.LocalDateTime

data class SaleHeaderQueryResponseDto(
    val id: Int,
    val saleDttm: LocalDateTime,
    val totalQty: Int,
    val totalPrice: Int
)