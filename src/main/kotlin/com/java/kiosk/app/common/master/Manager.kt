package com.java.kiosk.app.common.master

import com.java.kiosk.app.common.base.CommonEntity
import jakarta.persistence.*

@Entity(name = "tb_master_manager")
class Manager(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "NAME", nullable = false, length = 128)
    var name: String,

    @Column(name = "EMAIL", nullable = false, length = 128)
    var email: String,

    @Column(name = "PASSWORD", nullable = false, length = 128)
    var password: String
) : CommonEntity() {
}