package com.inventree.repository;

import com.inventree.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Product entity.
 * Extends JpaRepository to provide built-in CRUD operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides all basic CRUD methods:
    // save(), findAll(), findById(), deleteById(), etc.
}
