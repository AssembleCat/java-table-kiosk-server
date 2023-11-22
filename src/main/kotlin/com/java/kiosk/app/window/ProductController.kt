package com.java.kiosk.app.window

import com.java.kiosk.app.common.dto.request.ProductCreateRequestDto
import com.java.kiosk.app.core.service.core.ProductCoreService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class ProductController(
    private val productCoreService: ProductCoreService
) {
    @PostMapping
    fun createProduct(
        @RequestBody request: ProductCreateRequestDto
    ): Boolean {
        return productCoreService.create(request)
    }
}