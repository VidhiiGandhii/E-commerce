package org.ncu.ecommerce_app.controller;

import java.math.BigDecimal;
import java.util.List;

import org.ncu.ecommerce_app.entity.Product;
import org.ncu.ecommerce_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

 @Autowired
 private ProductService productService;

 @GetMapping
 public List<Product> getAllProducts() {
     return productService.getAllProducts();
 }

 @GetMapping("/{id}")
 public Product getProductById(@PathVariable Long id) {
     return productService.getProductById(id);
 }

 @GetMapping("/category/{categoryId}")
 public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
     return productService.getProductsByCategory(categoryId);
 }

 @GetMapping("/brand/{brandId}")
 public List<Product> getProductsByBrand(@PathVariable Long brandId) {
     return productService.getProductsByBrand(brandId);
 }

 @GetMapping("/price")
 public List<Product> getProductsByPriceRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
     return productService.getProductsByPriceRange(min, max);
 }
}
