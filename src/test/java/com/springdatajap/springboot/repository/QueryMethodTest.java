package com.springdatajap.springboot.repository;

import com.springdatajap.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){

        Product product = productRepository.findByName("product 2");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){

        List<Product> product = productRepository.findByNameOrDescription("product 1",
                "product 1 description");

        product.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){

        List<Product> product = productRepository.findByNameAndDescription("product 1",
                "product1 desc ");

        product.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
