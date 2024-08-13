package com.springdatajap.springboot.repository;

import com.springdatajap.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product1 desc ");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100
        ));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product savedObject = productRepository.save(product);

        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find or retrieve on entity id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity Information
        product.setName("update Product 1");
        product.setDescription("update product 1 desc");

        //save entity information
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;

        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod(){
        //create product

        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product2 desc ");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(200
        ));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product3 desc ");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(300
        ));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2, product3));
        System.out.println(product2.toString());
        System.out.println(product3.toString());
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id =2L;

        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        productRepository.deleteAll();
        Product product = productRepository.findById(5L).get();
        Product product1 = productRepository.findById(6L).get();

        productRepository.deleteAll(List.of(product, product1));

    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod(){
        Long id = 7L;
        Boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}