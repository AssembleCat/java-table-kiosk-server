package com.java.kiosk.app.common.master

import com.java.kiosk.app.common.base.CommonEntity
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
    var nameEnd: String?
) : CommonEntity() {
}