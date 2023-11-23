package com.java.kiosk.app.common.entity.sale

import com.java.kiosk.app.common.entity.base.CommonEntity
import com.java.kiosk.app.common.vto.SaleHeaderTotalVto
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "tb_sales_header")
class SaleHeader(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "MANAGER_ID", nullable = false)
    val managerId: Int,

    @Column(name = "TIME", columnDefinition = "TIMESTAMP")
    val time: LocalDateTime = LocalDateTime.now(),

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    @JoinColumn(name = "HEADER_ID")
    @OrderBy("PRODUCT_ID ASC")
    var detail: List<SaleDetail>
) : CommonEntity() {
    fun getTotalProps(): SaleHeaderTotalVto {
        return SaleHeaderTotalVto(
            detail.sumOf { it.qty },
            detail.sumOf { it.price }
        )
    }
}