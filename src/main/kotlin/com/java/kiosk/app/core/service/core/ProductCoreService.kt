package com.java.kiosk.app.core.service.core

import com.java.kiosk.app.common.dto.request.ProductCreateRequestDto
import com.java.kiosk.app.common.dto.request.ProductUpdateRequestDto
import com.java.kiosk.app.core.domain.repository.master.ProductRepository
import com.java.kiosk.app.core.service.product.ProductService
import jakarta.persistence.EntityNotFoundException
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

    fun update(request: ProductUpdateRequestDto): Boolean {
        val product = productRepository.findById(request.productId)
            .orElseThrow { EntityNotFoundException("Product not found") }

        product.update(request)

        return true
    }
}