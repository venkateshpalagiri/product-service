package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;

import java.util.List;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
    ProductResponse getProductById(long productId);
    ProductResponse updateProductById(long productId,ProductRequest productRequest);
    String deleteProductById(long productId);

    List<Product> getAllProducts();
}
