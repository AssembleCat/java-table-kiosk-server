package com.java.kiosk.app.common.sale

import com.java.kiosk.app.common.base.CommonEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "tb_sales_header")
class SaleHeader(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "MANAGER_ID", nullable = false)
    val managerId: Int,

    @Column(name = "TIME", columnDefinition = "TIMESTAMP")
    val time: LocalDateTime = LocalDateTime.now()
    ) : CommonEntity() {
}