package com.venkatesh.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String productName;
    private long productPrice;
    private long productQuantity;

    public String getProductName() {
        return productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

}
