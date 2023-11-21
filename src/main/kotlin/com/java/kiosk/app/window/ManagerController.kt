package com.java.kiosk.app.window

import com.java.kiosk.app.common.dto.response.ManagerLoginResponseDto
import com.java.kiosk.app.core.service.core.ManagerCoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/manager")
class ManagerController(
    private val managerCoreService: ManagerCoreService
) {
    @GetMapping("/login")
    fun managerLogin(
        @RequestParam("email") email: String,
        @RequestParam("password") password: String
    ): ManagerLoginResponseDto? {
        return managerCoreService.checkLogin(email, password)
    }
}
