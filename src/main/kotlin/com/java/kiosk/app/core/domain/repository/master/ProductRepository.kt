package com.java.kiosk.app.core.domain.repository.master

import com.java.kiosk.app.common.entity.master.Manager
import com.java.kiosk.app.common.entity.master.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Int> {
    fun findByManager(manager: Manager): List<Product>
}