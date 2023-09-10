package com.buywithme.buywithmeproductservice.service.impl;

import com.buywithme.buywithmeproductservice.dto.ProductRequestDto;
import com.buywithme.buywithmeproductservice.dto.responses.ProductResponse;
import com.buywithme.buywithmeproductservice.model.Product;
import com.buywithme.buywithmeproductservice.repository.ProductRepository;
import com.buywithme.buywithmeproductservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequestDto productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("BuyWithMe: Product {} is Saved Successfully", product.getId());
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }


    /**
     * Internal Methods
     * */
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
