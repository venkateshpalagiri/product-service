package com.venkatesh.ProductService.controller;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;
import com.venkatesh.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    Getting a Product...
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){

        Product product=productService.getProductById(productId);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }

//    Get all Products...
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        List<Product> productList=productService.getAllProducts();
        return productList;
    }
//    Updating a Product...
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") long productId,@RequestBody Product product){
        Product product1=productService.updateProductById(productId,product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

//    Deleting a Product...
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") long productId){
        String product=productService.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted with id:"+productId,HttpStatus.GONE);
    }
}

