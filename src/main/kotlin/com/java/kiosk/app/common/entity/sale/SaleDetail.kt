package com.java.kiosk.app.common.entity.sale

import com.java.kiosk.app.common.entity.base.CommonEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "tb_sales_detail")
class SaleDetail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "HEADER_ID", nullable = false)
    val headerId: Int,

    @Column(name = "PRODUCT_ID", nullable = false)
    val productId: Int,

    @Column(name = "QTY", nullable = false)
    val qty: Int,

    @Column(name = "PRICE", nullable = false)
    val price: ULong
): CommonEntity() {
}