package org.springframework.samples.petclinic.inventory.web;

import org.springframework.samples.petclinic.inventory.model.Product;
import org.springframework.samples.petclinic.inventory.model.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InventoryRessource {

    private final ProductRepository productRepository;

    public InventoryRessource(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
