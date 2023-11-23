package com.java.kiosk.app.core.service.core

import com.java.kiosk.app.common.dto.request.SaleCreateRequestDto
import com.java.kiosk.app.common.dto.response.SaleDetailQueryResponseDto
import com.java.kiosk.app.common.dto.response.SaleHeaderQueryResponseDto
import com.java.kiosk.app.core.domain.repository.sale.SaleDetailRepository
import com.java.kiosk.app.core.domain.repository.sale.SaleHeaderRepository
import com.java.kiosk.app.core.service.sale.SaleHeaderService
import org.springframework.stereotype.Service

@Service
class PaymentCoreService(
    private val saleHeaderService: SaleHeaderService,
    private val saleHeaderRepository: SaleHeaderRepository,
    private val saleDetailRepository: SaleDetailRepository
) {
    fun queryHeader(managerId: Int): List<SaleHeaderQueryResponseDto> {
        val headers = saleHeaderRepository.findByManagerId(managerId)

        return headers.map { header ->
            val totalProps = header.getTotalProps()
            SaleHeaderQueryResponseDto(
                id = header.id!!,
                saleDttm = header.time,
                totalQty = totalProps.qty,
                totalPrice = totalProps.price
            )
        }
    }

    fun queryDetail(headerId: Int): List<SaleDetailQueryResponseDto> {
        val details = saleDetailRepository.findByHeaderId(headerId)

        return details.map { detail ->
            SaleDetailQueryResponseDto(
                productName = detail.product.name,
                qty = detail.qty,
                price = detail.product.price
            )
        }
    }

    fun persistSale(request: SaleCreateRequestDto): Boolean {
        return try {
            val header = saleHeaderService.createSaleHeader(request)

            saleHeaderRepository.save(header)

            true
        } catch (e: Exception) {
            false
        }
    }
}