package com.java.kiosk.app.common.dto.request


data class SaleCreateRequestDto(
    val managerId: Int,
    val saleProduct: List<SaleProduct>
)

data class SaleProduct(
    val id: Int,
    val qty: Int
)