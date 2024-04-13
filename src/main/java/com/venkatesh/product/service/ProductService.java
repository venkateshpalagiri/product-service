package com.venkatesh.product.service;

import com.venkatesh.product.dto.ProductRequest;
import com.venkatesh.product.dto.ProductResponse;
import com.venkatesh.product.model.Product;
import com.venkatesh.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    final private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        ProductResponse productResponse= new ProductResponse(
                product.getId(),product.getName(),product.getDescription(),product.getPrice()
        );
        log.info("Product crated successfully");
        return productResponse;
    }
    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice())).toList();
    }
}
