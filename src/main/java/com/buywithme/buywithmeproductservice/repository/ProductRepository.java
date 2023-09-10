package com.buywithme.buywithmeproductservice.repository;

import com.buywithme.buywithmeproductservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {



}
