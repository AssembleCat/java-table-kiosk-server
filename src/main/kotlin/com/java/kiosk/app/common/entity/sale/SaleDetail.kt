package com.java.kiosk.app.common.entity.sale

import com.java.kiosk.app.common.entity.base.CommonEntity
import com.java.kiosk.app.common.entity.master.Product
import jakarta.persistence.*

@Entity(name = "tb_sales_detail")
class SaleDetail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "HEADER_ID", nullable = false)
    val headerId: Int,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    val product: Product,

    @Column(name = "QTY", nullable = false)
    val qty: Int,

    @Column(name = "PRICE", nullable = false)
    val price: Int
): CommonEntity() {
}