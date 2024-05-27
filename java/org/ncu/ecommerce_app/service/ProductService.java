package org.ncu.ecommerce_app.service;

import java.math.BigDecimal;
import java.util.List;

import org.ncu.ecommerce_app.entity.Product;

public interface ProductService {
	 List<Product> getAllProducts();
	    Product getProductById(Long id);
	    Product createProduct(Product product);
	    Product updateProduct(Long id, Product product);
	    void deleteProduct(Long id);
		List<Product> getProductsByCategory(Long categoryId);
		List<Product> getProductsByBrand(Long brandId);
		List<Product> getProductsByPriceRange(BigDecimal min, BigDecimal max);

}
