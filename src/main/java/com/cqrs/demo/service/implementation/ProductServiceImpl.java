package com.cqrs.demo.service.implementation;

import com.cqrs.demo.DAO.ProductRepository;
import com.cqrs.demo.DTO.ProductEvent;
import com.cqrs.demo.entity.Product;
import com.cqrs.demo.service.apstraction.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
  public  ProductServiceImpl(ProductRepository productRepository ,KafkaTemplate<String, Object> kafkaTemplate){
        this.productRepository=productRepository;
        this.kafkaTemplate =kafkaTemplate;
    }
    @Override
    public Product createProduct(ProductEvent productEvent) {

        Product product = productRepository.save(productEvent.getProduct());
        ProductEvent productEvent1= new ProductEvent("CREATE_PRODUCT",product);
        kafkaTemplate.send("PRODUCT_EVENT_TOPIC",productEvent1);
        return  product;
            }

    @Override
    public Product updateProduct(ProductEvent productEvent) {
        Product product1 = productRepository.save(productEvent.getProduct());
        ProductEvent productEvent1= new ProductEvent("UPDATE_PRODUCT",product1);
        kafkaTemplate.send("PRODUCT_EVENT_TOPIC",productEvent1);

        return  product1;
    }

    @Override
    public void deleteProductById(long ProductID) {
        productRepository.deleteById(ProductID);
    }
}
