package com.venkatesh.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long productId;
    private String productName;
    private long productPrice;
    private long productQuantity;


//    public ProductResponse() {
//
//    }
//    public ProductResponse(Long productId, String productName, long productPrice, long productQuantity) {
//        this.productId = productId;
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.productQuantity = productQuantity;
//    }



//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public void setProductPrice(long productPrice) {
//        this.productPrice = productPrice;
//    }
//
//    public void setProductQuantity(long productQuantity) {
//        this.productQuantity = productQuantity;
//    }

}
