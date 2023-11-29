package com.java.kiosk.app.common.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ProductQueryResponseDto (
    val id: Int,
    val name: String,
    val nameEng: String,
    val price: Int
)