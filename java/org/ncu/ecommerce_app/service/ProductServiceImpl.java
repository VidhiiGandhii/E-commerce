package org.ncu.ecommerce_app.service;

import java.math.BigDecimal;
import java.util.List;

import org.ncu.ecommerce_app.dao.ProductDao;
import org.ncu.ecommerce_app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productDao.findById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImageUrl(product.getImageUrl());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            return productDao.save(existingProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productDao.findByCategory(categoryId);
    }

    @Override
    public List<Product> getProductsByBrand(Long brandId) {
        return productDao.findByBrand(brandId);
    }

    @Override
    public List<Product> getProductsByPriceRange(BigDecimal min, BigDecimal max) {
        return productDao.findByPriceBetween(min, max);
    }
}
