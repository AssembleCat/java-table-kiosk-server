package com.java.kiosk.app.core.service.core

import com.java.kiosk.app.common.dto.response.ManagerLoginResponseDto
import com.java.kiosk.app.core.domain.mapper.manager.toManagerLoginResponseDto
import com.java.kiosk.app.core.domain.repository.master.ManagerRepository
import org.springframework.stereotype.Service

@Service
class ManagerCoreService (
    private val managerRepository: ManagerRepository
){
    fun checkLogin(email: String, password: String): ManagerLoginResponseDto? {
        val manager = managerRepository.findByEmailAndPassword(email, password) ?: return null

        return manager.toManagerLoginResponseDto()
    }
}