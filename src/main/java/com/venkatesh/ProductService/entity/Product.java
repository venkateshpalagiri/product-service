package com.venkatesh.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_PRICE")
    private long productPrice;
    @Column(name = "PRODUCT_QUANTITY")
    private long productQuantity;

//    public Long getProductId() {
//        return productId;
//    }
//
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
//
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
