package com.venkatesh.ProductService.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ProductNotFoundException extends RuntimeException{

    private String errorCode;

    public ProductNotFoundException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
