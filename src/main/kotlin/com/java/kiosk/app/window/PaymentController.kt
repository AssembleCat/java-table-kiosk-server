package com.java.kiosk.app.window

import com.java.kiosk.app.common.dto.response.SaleDetailQueryResponseDto
import com.java.kiosk.app.common.dto.response.SaleHeaderQueryResponseDto
import com.java.kiosk.app.core.service.core.PaymentCoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payment")
class PaymentController(
    private val paymentCoreService: PaymentCoreService
) {
    @GetMapping
    fun querySales(
        @RequestParam("managerId") managerId: Int
    ): List<SaleHeaderQueryResponseDto> {
        return paymentCoreService.queryHeader(managerId)
    }

    @GetMapping("/detail")
    fun queryDetails(
        @RequestParam("headerId") headerId: Int
    ): List<SaleDetailQueryResponseDto> {
        return paymentCoreService.queryDetail(headerId)
    }

}