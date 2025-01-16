package com.venkatesh.ProductService.model;

import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductRequest {

    private String productName;
    private long productPrice;
    private long productQuantity;

//    public String getProductName() {
//        return productName;
//    }
//
//    public long getProductPrice() {
//        return productPrice;
//    }
//
//    public long getProductQuantity() {
//        return productQuantity;
//    }

}
