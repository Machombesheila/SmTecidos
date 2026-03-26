package com.inventree.service;

import com.inventree.entity.Product;
import com.inventree.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for Product business logic.
 * Acts as an intermediary between Controller and Repository.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Save a new product or update an existing product.
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieve all products from the database.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieve a single product by its ID.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    /**
     * Delete a product by its ID.
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
