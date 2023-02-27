package com.carrotdetector.springbootmall.service.Impl;

import com.carrotdetector.springbootmall.dao.ProductDao;
import com.carrotdetector.springbootmall.dto.ProductRequest;
import com.carrotdetector.springbootmall.model.Product;
import com.carrotdetector.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
