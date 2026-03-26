package com.inventree.controller;

import com.inventree.entity.Product;
import com.inventree.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling product-related HTTP requests.
 * Follows Spring MVC pattern with Thymeleaf views.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Display all products.
     * URL: /products
     */
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    /**
     * Show the Add Product form.
     * URL: /add (GET)
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    /**
     * Handle Add Product form submission.
     * URL: /add (POST)
     */
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "add-product";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * Show the Edit Product form.
     * URL: /edit/{id}
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    /**
     * Handle Edit Product form submission.
     * URL: /edit/{id} (POST)
     */
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "edit-product";
        }
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * Delete a product.
     * URL: /delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    /**
     * Redirect root URL to products list.
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }
}
