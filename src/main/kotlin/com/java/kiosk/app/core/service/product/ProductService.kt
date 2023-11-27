package com.java.kiosk.app.core.service.product

import com.java.kiosk.app.common.dto.request.ProductCreateRequestDto
import com.java.kiosk.app.common.entity.master.Manager
import com.java.kiosk.app.common.entity.master.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun createProduct(request: ProductCreateRequestDto, manager: Manager): Product {
        return Product(
            price = request.price,
            name = request.name,
            nameEng = request.nameEng,
            manager = manager
        )
    }
}