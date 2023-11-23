package com.java.kiosk.app.core.service.sale

import com.java.kiosk.app.common.dto.request.SaleCreateRequestDto
import com.java.kiosk.app.common.entity.sale.SaleDetail
import com.java.kiosk.app.common.entity.sale.SaleHeader
import com.java.kiosk.app.core.domain.repository.master.ManagerRepository
import com.java.kiosk.app.core.domain.repository.master.ProductRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class SaleHeaderService(
    private val managerRepository: ManagerRepository,
    private val productRepository: ProductRepository
) {

    fun createSaleHeader(request: SaleCreateRequestDto): SaleHeader {
        val manager = managerRepository.findById(request.managerId)
            .orElseThrow { EntityNotFoundException("User not found") }

        return SaleHeader(
            manager = manager,
            details = request.saleProduct.map { sale ->
                SaleDetail(
                    qty = sale.qty,
                    product = productRepository.findById(sale.id)
                        .orElseThrow { EntityNotFoundException("Product not found") }
                )
            }
        )
    }
}