package org.ncu.ecommerce_app.dao;

import org.ncu.ecommerce_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Long
> {

}
