package com.java.kiosk.app.core.domain.repository.sale

import com.java.kiosk.app.common.entity.sale.SaleHeader
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleHeaderRepository: JpaRepository<SaleHeader, Int> {
    fun findByManagerId(managerId: Int): List<SaleHeader>
}