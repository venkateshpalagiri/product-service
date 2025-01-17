package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.Exception.ProductNotFoundException;
import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;
import com.venkatesh.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

//    private final Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
    @Override
    public long addProduct(ProductRequest productRequest) {

        log.info("Adding product...");
        Product product=Product.builder()
                .productName(productRequest.getProductName())
                .productPrice(productRequest.getProductPrice())
                .productQuantity(productRequest.getProductQuantity())
                .build();

//        *** write logic for validation of incoming data ***
//        Product product=new Product();
//        product.setProductName(productRequest.getProductName());
//        product.setProductPrice(productRequest.getProductPrice());
//        product.setProductQuantity(productRequest.getProductQuantity());

        productRepository.save(product);
        log.info("Product has been added successfully...");

        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {

        Product product=productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("There's no record of Product with Id:"+productId, "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse=ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .build();

//        productResponse.setProductId(product.getProductId());
//        productResponse.setProductName(product.getProductName());
//        productResponse.setProductPrice(product.getProductPrice());
//        productResponse.setProductQuantity(product.getProductQuantity());
//        System.out.println(productResponse);


        return productResponse;
    }

    @Override
    public ProductResponse updateProductById(long productId, ProductRequest productRequest) {

        Product product=productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found with id:"+productId,"PRODUCT_NOT_FOUND)"));

        if(Objects.nonNull(productRequest.getProductName())&&!"".equalsIgnoreCase(productRequest.getProductName())){
            product.setProductName(productRequest.getProductName());
        }

        if(product.getProductQuantity()<productRequest.getProductQuantity()){
            product.setProductQuantity(productRequest.getProductQuantity());
        }

        if(productRequest.getProductPrice()!=0 && productRequest.getProductPrice()>=2000){
            product.setProductPrice(productRequest.getProductPrice());
        }

//        ProductResponse productResponse=product.builder()
//                        .productId(product.getProductId())
//                                .productName(product.getProductName())
//                                        .productPrice(productId)

        productRepository.save(product);

        ProductResponse productResponse=ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .build();

        return productResponse;
    }

    @Override
    public String deleteProductById(long productId) {

        Product product=productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found with id:"+productId,"PRODUCT_NOT_FOUND)"));

        productRepository.delete(product);
        return "product has been delted with id: "+productId;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList=productRepository.findAll();

        return productList;
    }
}
