package com.java.kiosk.app.window

import com.java.kiosk.app.common.dto.request.ProductCreateRequestDto
import com.java.kiosk.app.common.dto.request.ProductUpdateRequestDto
import com.java.kiosk.app.common.dto.response.ProductQueryResponseDto
import com.java.kiosk.app.core.service.core.ProductCoreService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController(
    private val productCoreService: ProductCoreService
) {
    @GetMapping("/{managerId}")
    fun queryProduct(
        @PathVariable("managerId") managerId: Int
    ): List<ProductQueryResponseDto> {
        return productCoreService.query(managerId)
    }

    @PostMapping
    fun createProduct(
        @RequestBody request: ProductCreateRequestDto
    ): Boolean {
        return productCoreService.create(request)
    }

    @PutMapping
    fun updateProduct(
        @RequestBody request: ProductUpdateRequestDto
    ): Boolean {
        return productCoreService.update(request)
    }
}