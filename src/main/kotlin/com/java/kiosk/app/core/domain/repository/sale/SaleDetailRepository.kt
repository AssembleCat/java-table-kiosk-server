package com.java.kiosk.app.core.domain.repository.sale

import com.java.kiosk.app.common.sale.SaleDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleDetailRepository: JpaRepository<SaleDetail, Int> {
    fun findByHeaderId(headerId: Int): List<SaleDetail>
    fun findByProductId(productId: Int): List<SaleDetail>
}