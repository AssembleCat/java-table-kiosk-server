package com.java.kiosk.app.core.service.sale

import com.java.kiosk.app.common.dto.request.SaleCreateRequestDto
import com.java.kiosk.app.common.entity.sale.SaleDetail
import com.java.kiosk.app.common.entity.sale.SaleHeader
import com.java.kiosk.app.core.domain.repository.master.ManagerRepository
import com.java.kiosk.app.core.domain.repository.master.ProductRepository
import com.java.kiosk.app.core.domain.repository.sale.SaleDetailRepository
import com.java.kiosk.app.core.domain.repository.sale.SaleHeaderRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaleHeaderService(
    private val managerRepository: ManagerRepository,
    private val productRepository: ProductRepository,
    private val saleHeaderRepository: SaleHeaderRepository,
    private val saleDetailRepository: SaleDetailRepository
) {

    @Transactional
    fun createSaleHeader(request: SaleCreateRequestDto): SaleHeader {
        val manager = managerRepository.findById(request.managerId)
            .orElseThrow { EntityNotFoundException("User not found") }

        val saleHeader = SaleHeader(manager = manager)
        saleHeaderRepository.save(saleHeader)

        val saleDetails = request.saleProduct.map { sale ->
            val product = productRepository.findById(sale.id)
                .orElseThrow { EntityNotFoundException("Product not found") }

            val saleDetail = SaleDetail(qty = sale.qty, product = product, header = saleHeader)
            saleDetailRepository.save(saleDetail)
            saleDetail
        }

        saleHeader.details = saleDetails

        return saleHeader
    }
}