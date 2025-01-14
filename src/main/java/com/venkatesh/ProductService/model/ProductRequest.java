package com.venkatesh.ProductService.model;

import lombok.Data;
import lombok.Getter;

//@Data
//@Getter
public class ProductRequest {
    public String getProductName() {
        return productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    private String productName;
    private long productPrice;
    private long productQuantity;
}
