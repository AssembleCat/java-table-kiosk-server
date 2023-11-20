package com.java.kiosk.app.common.base

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@MappedSuperclass
class CommonEntity(
    @Column(name = "create_at", updatable = false)
    var createAt: LocalDateTime,
    @Column(name = "update_at")
    var updateAt: LocalDateTime
) {
    @PrePersist
    fun prePersist() {
        val now = LocalDateTime.now()

        apply {
            createAt = now
            updateAt = now
        }
    }

    @PreUpdate
    fun preUpdate() {
        apply {
            updateAt = LocalDateTime.now()
        }
    }
}