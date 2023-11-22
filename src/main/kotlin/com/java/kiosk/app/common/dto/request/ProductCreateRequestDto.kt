package com.java.kiosk.app.common.dto.request


data class ProductCreateRequestDto (
    val price: Int,
    val name: String,
    val nameEng: String?
)