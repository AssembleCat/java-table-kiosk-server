package com.java.kiosk.app.window

import com.java.kiosk.app.common.dto.request.SaleCreateRequestDto
import com.java.kiosk.app.common.dto.response.SaleDetailQueryResponseDto
import com.java.kiosk.app.common.dto.response.SaleHeaderQueryResponseDto
import com.java.kiosk.app.core.service.core.PaymentCoreService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/payment")
class PaymentController(
    private val paymentCoreService: PaymentCoreService
) {
    @GetMapping
    fun querySales(
        @RequestParam("managerId") managerId: Int
    ): ResponseEntity<Map<String, List<SaleHeaderQueryResponseDto>>> {
        return ResponseEntity.ok(mapOf("headers" to paymentCoreService.queryHeader(managerId)))
    }

    @GetMapping("/detail")
    fun queryDetails(
        @RequestParam("headerId") headerId: Int
    ): List<SaleDetailQueryResponseDto> {
        return paymentCoreService.queryDetail(headerId)
    }

    @PostMapping
    fun createSale(
        @RequestBody request: SaleCreateRequestDto
    ): Boolean {
        return paymentCoreService.persistSale(request)
    }
}