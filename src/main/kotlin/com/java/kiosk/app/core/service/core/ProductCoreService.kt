package com.java.kiosk.app.core.service.core

import com.java.kiosk.app.common.dto.request.ProductCreateRequestDto
import com.java.kiosk.app.core.domain.repository.master.ProductRepository
import com.java.kiosk.app.core.service.product.ProductService
import org.springframework.stereotype.Service

@Service
class ProductCoreService(
    private val productService: ProductService,
    private val productRepository: ProductRepository
) {
    fun create(request: ProductCreateRequestDto): Boolean {
        return try {
            val product = productService.createProduct(request)

            productRepository.save(product)

            true
        } catch (e: Exception) {
            false
        }
    }
}