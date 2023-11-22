package com.java.kiosk.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.java.kiosk.app"])
class JavaTableKioskServerApplication

fun main(args: Array<String>) {
    runApplication<JavaTableKioskServerApplication>(*args)
}
