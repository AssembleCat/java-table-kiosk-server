package com.java.kiosk.app.core.domain.repository.master

import com.java.kiosk.app.common.master.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Int> {
    fun findByName(name: String): Product
}