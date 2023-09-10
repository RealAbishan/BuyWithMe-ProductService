package com.buywithme.buywithmeproductservice.service;

import com.buywithme.buywithmeproductservice.dto.ProductRequestDto;
import com.buywithme.buywithmeproductservice.dto.responses.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequestDto productRequest);

    List<ProductResponse> getAllProducts();
}
