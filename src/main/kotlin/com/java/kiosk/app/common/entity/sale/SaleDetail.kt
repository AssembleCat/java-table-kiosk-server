package com.java.kiosk.app.common.entity.sale

import com.java.kiosk.app.common.entity.base.CommonEntity
import com.java.kiosk.app.common.entity.master.Product
import jakarta.persistence.*

@Entity(name = "tb_sales_detail")
class SaleDetail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "QTY", nullable = false)
    val qty: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEADER_ID", nullable = false)
    val header: SaleHeader? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    val product: Product
) : CommonEntity() {
}