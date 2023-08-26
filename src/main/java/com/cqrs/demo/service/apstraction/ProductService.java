package com.cqrs.demo.service.apstraction;

import com.cqrs.demo.DTO.ProductEvent;
import com.cqrs.demo.entity.Product;

public interface ProductService {


    public Product createProduct(ProductEvent productEvent );
    public Product updateProduct(ProductEvent productEvent);

    public void deleteProductById(long ProductID);





}
