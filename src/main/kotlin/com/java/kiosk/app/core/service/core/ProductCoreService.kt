package com.java.kiosk.app.core.service.core

import com.java.kiosk.app.common.dto.request.ProductCreateRequestDto
import com.java.kiosk.app.common.dto.request.ProductUpdateRequestDto
import com.java.kiosk.app.common.dto.response.ProductQueryResponseDto
import com.java.kiosk.app.core.domain.repository.master.ManagerRepository
import com.java.kiosk.app.core.domain.repository.master.ProductRepository
import com.java.kiosk.app.core.service.product.ProductService
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class ProductCoreService(
    private val productService: ProductService,
    private val productRepository: ProductRepository,
    private val managerRepository: ManagerRepository
) {
    fun query(managerId: Int): List<ProductQueryResponseDto> {
        val manager = managerRepository.findById(managerId)
            .orElseThrow { EntityNotFoundException("User not found") }

        val products = productRepository.findByManager(manager)

        return products.map { product ->
            ProductQueryResponseDto(
                id = product.id!!,
                name = product.name,
                nameEnd = product.nameEng ?: product.name,
                price = product.price
            )
        }
    }

    fun create(request: ProductCreateRequestDto): Boolean {
        return try {
            val manager = managerRepository.findById(request.managerId)
                .orElseThrow { EntityNotFoundException("User not found") }
            val product = productService.createProduct(request, manager)

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