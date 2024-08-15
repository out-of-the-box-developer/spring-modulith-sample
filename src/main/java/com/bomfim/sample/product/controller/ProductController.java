package com.bomfim.sample.product.controller;

import com.bomfim.sample.product.IProductService;
import com.bomfim.sample.product.domain.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductInputDto productInputDto) {
        ProductEntity product = productService.createProduct(productInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable Long id) {
        var product = productService.getProductById(id).orElseThrow();
        return ResponseEntity.ok(product);
    }
}
