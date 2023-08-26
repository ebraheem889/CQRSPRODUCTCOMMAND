package com.cqrs.demo.controller;


import com.cqrs.demo.DTO.ProductEvent;
import com.cqrs.demo.entity.Product;
import com.cqrs.demo.service.apstraction.ProductService;
import com.cqrs.demo.service.implementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {


    private final ProductService productService;

    @Autowired
    ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }


   @PostMapping
    public Product createProduct(@RequestBody ProductEvent productEvent){
       return productService.createProduct(productEvent);
    }

    @PutMapping
    public Product updateProduct(@RequestBody ProductEvent productEvent){
        return productService.updateProduct(productEvent);
    }

    @DeleteMapping("{ProductId}")
    public void deleteProductById(@PathVariable long ProductId) {
        productService.deleteProductById(ProductId);
    }
}
