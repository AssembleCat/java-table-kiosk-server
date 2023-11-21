package com.java.kiosk.app.core.domain.mapper.manager

import com.java.kiosk.app.common.dto.response.ManagerLoginResponseDto
import com.java.kiosk.app.common.entity.master.Manager

fun Manager.toManagerLoginResponseDto(): ManagerLoginResponseDto {
    return ManagerLoginResponseDto(
        this.id!!,
        this.name,
        this.email,
        this.password
    )
}