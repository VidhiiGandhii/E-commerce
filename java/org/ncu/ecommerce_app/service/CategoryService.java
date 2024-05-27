package org.ncu.ecommerce_app.service;

import java.util.List;

import org.ncu.ecommerce_app.entity.Category;

public interface CategoryService {
	  List<Category> getAllCategories();
	    Category getCategoryById(Long id);
	    Category createCategory(Category category);
	    Category updateCategory(Long id, Category category);
	    void deleteCategory(Long id);
}
