package org.ncu.ecommerce_app.dao;

import java.math.BigDecimal;
import java.util.List;

import org.ncu.ecommerce_app.entity.Product;

public interface ProductDao {
	public List<Product> findAll();
	public Product findById(Long id);
	public Product save(Product product);
	public void deleteById(Long id);
	public List<Product> findByBrand(Long brandId);
    public List<Product> findByCategory(Long categoryId);
    public List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

}
