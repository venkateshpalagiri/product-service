package com.venkatesh.ProductService.Exception;

import com.venkatesh.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ProductServiceCustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException productNotFoundException){

        return new ResponseEntity<>(new ErrorResponse().builder()
                .message(productNotFoundException.getMessage())
                .errorCode(productNotFoundException.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);

    }

}
