package com.carrotdetector.springbootmall.service;

import com.carrotdetector.springbootmall.dto.ProductRequest;
import com.carrotdetector.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
