package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    private final Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
    @Override
    public long addProduct(ProductRequest productRequest) {

        log.info("Adding product...");
//        Product product=Product.builder()
//                .productName(productRequest.getProductName())
//                .productPrice(productRequest.getProductPrice())
//                .productQuantity(productRequest.getProductQuantity())
//                .build();

//        *** write logic for validation of incoming data ***
        Product product=new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductPrice(productRequest.getProductPrice());
        product.setProductQuantity(productRequest.getProductQuantity());

        productRepository.save(product);
        log.info("Product has been added successfully...");

        return product.getProductId();
    }
}
