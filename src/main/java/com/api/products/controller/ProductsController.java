package com.api.products.controller;


import com.api.products.entity.ProductsEntity;
import com.api.products.service.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Product Management", description = "Endpoints for managing products")
public class ProductsController {

    private final ProductsService service;

    public ProductsController(ProductsService service) {
        this.service = service;
    }

    @PostMapping("/products/add")
    @Operation(summary = "Add a new product", description = "Provide necessary product details to add a new product.")
    public ProductsEntity addProducts(@RequestBody ProductsEntity products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    @Operation(summary = "Get all products", description = "Retrieve a list of all available products.")
    public List<ProductsEntity> getProducts() {
        return service.findProducts();
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieve details of a specific product using its ID.")
    public Optional<ProductsEntity> getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }


    @PutMapping("/products/{id}")
    @Operation(summary = "Update product by ID", description = "Update details of a specific product using its ID.")
    public ProductsEntity updateProduct(@PathVariable Long id, @RequestBody ProductsEntity product) {
        product.setId(id);
        return service.updateProduct(id, product);
    }


    @DeleteMapping("/products/delete/{id}")
    @Operation(summary = "Delete product by ID", description = "Delete a specific product using its ID.")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
    {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
