package itis.homework.demo.Controller;


import itis.homework.demo.Dto.Product;
import itis.homework.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products-management/")
public class ProductsApiController {

    @Autowired
    private ProductRepository productsRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productsRepository.findAll());
    }

    @GetMapping("/products/{product-id}")
    public ResponseEntity<Product> getProduct(@PathVariable("product-id") Long productId) {
        Product product = productsRepository.findById(productId).get();
        return ResponseEntity.ok(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productsRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{product-id}")
    public ResponseEntity deleteProduct(@PathVariable("product-id") Long productId) {
        productsRepository.deleteById(productId);
        return ResponseEntity.accepted().build();
    }
}

