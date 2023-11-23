package com.java.kiosk.app.common.dto.request

data class ProductUpdateRequestDto (
    val productId: Int,
    val price: Int?,
    val name: String?,
    val nameEng: String?
)