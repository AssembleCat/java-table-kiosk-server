package com.java.kiosk.app.common.entity.sale

import com.java.kiosk.app.common.entity.base.CommonEntity
import com.java.kiosk.app.common.entity.master.Manager
import com.java.kiosk.app.common.vto.SaleHeaderTotalVto
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "tb_sales_header")
class SaleHeader(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "TIME", columnDefinition = "TIMESTAMP")
    val time: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY,)
    @JoinColumn(name = "managerId", nullable = false)
    val manager: Manager,

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        mappedBy = "header"
    )
    @OrderBy("PRODUCT_ID ASC")
    var details: List<SaleDetail> = mutableListOf()
) : CommonEntity() {
    fun getTotalProps(): SaleHeaderTotalVto {
        return SaleHeaderTotalVto(
            details.sumOf { it.qty },
            details.sumOf { it.product.price }
        )
    }
}