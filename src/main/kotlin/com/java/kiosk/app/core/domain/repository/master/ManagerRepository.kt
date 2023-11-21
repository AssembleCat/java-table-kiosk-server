package com.java.kiosk.app.core.domain.repository.master

import com.java.kiosk.app.common.entity.master.Manager
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ManagerRepository: JpaRepository<Manager, Int> {
    fun findByEmailAndPassword(email: String, password: String): Manager?
}