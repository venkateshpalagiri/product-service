package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;
import com.venkatesh.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Product getProductById(long productId) {

        Product product=productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Product not found with Id:"+productId));

        ProductResponse productResponse=new ProductResponse();

        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setProductPrice(product.getProductPrice());
        productResponse.setProductQuantity(product.getProductQuantity());
        System.out.println(productResponse);


        return product;
    }

    @Override
    public Product updateProductById(long productId, Product product) {

        Product product1=productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Product not found with id:"+productId));

        if(Objects.nonNull(product.getProductName())&&!"".equalsIgnoreCase(product.getProductName())){
            product1.setProductName(product.getProductName());
        }

        if(product1.getProductQuantity()<product.getProductQuantity()){
            product1.setProductQuantity(product.getProductQuantity());
        }

        if(product.getProductPrice()!=0 && product.getProductPrice()>=2000){
            product1.setProductPrice(product.getProductPrice());
        }

        productRepository.save(product1);

        return product1;
    }

    @Override
    public String deleteProductById(long productId) {

        Product product=productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Product not found with id:"+productId));

        productRepository.delete(product);
        return "product has been delted with id: "+productId;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList=productRepository.findAll();

        return productList;
    }
}
