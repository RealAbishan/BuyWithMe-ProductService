package com.buywithme.buywithmeproductservice.controller;

import com.buywithme.buywithmeproductservice.dto.ProductRequestDto;
import com.buywithme.buywithmeproductservice.dto.responses.ProductResponse;
import com.buywithme.buywithmeproductservice.model.Product;
import com.buywithme.buywithmeproductservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto productRequest) {
        log.info("HIT - /api/product POST | ProductName {} | ProductDescription {} | ProductPrice {}:", productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct() {
        log.info("HIT - /api/product GET |");
        return productService.getAllProducts();
    }
}
