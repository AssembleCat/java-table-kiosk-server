package com.java.kiosk.app.common.entity.master

import com.java.kiosk.app.common.dto.request.ProductUpdateRequestDto
import com.java.kiosk.app.common.entity.base.CommonEntity
import jakarta.persistence.*

@Entity(name = "tb_master_product")
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "PRICE", nullable = false)
    var price: Int,

    @Column(name = "NAME", nullable = false, length = 512)
    var name: String,

    @Column(name = "NAME_ENG", length = 512)
    var nameEng: String?,

    @Column(name = "USE_YN", nullable = false)
    var useYn: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId", nullable = false)
    var manager: Manager
) : CommonEntity() {
    fun update(request: ProductUpdateRequestDto) {
        apply {
            price = request.price ?: price
            name = request.name ?: name
            nameEng = request.nameEng ?: nameEng
        }
    }
}