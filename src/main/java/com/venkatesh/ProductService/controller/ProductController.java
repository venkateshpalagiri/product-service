package com.venkatesh.ProductService.controller;

import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private final Logger log= LoggerFactory.getLogger(ProductController.class);

//    Adding a Product...
    @PostMapping()
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        log.info("Calling Service layer addProduct method...");
        long productId=productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.OK);

    }
}
