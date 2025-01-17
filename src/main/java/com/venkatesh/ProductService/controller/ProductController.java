package com.venkatesh.ProductService.controller;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;
import com.venkatesh.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

//    private final Logger log= LoggerFactory.getLogger(ProductController.class);

//    Adding a Product...
    @PostMapping()
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        log.info("Calling Service layer addProduct method...");
        long productId=productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.OK);

    }

//    Getting a Product...
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){

        ProductResponse productResponse=productService.getProductById(productId);

        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

//    Get all Products...
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> productList=productService.getAllProducts();

        return new ResponseEntity<>(productList,HttpStatus.OK);
    }
//    Updating a Product...
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable("id") long productId,@RequestBody ProductRequest productRequest){

        ProductResponse productResponse=productService.updateProductById(productId,productRequest);

        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

//    Deleting a Product...
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") long productId){

        String product=productService.deleteProductById(productId);

        return new ResponseEntity<>("Product deleted with id:"+productId,HttpStatus.GONE);
    }
}

