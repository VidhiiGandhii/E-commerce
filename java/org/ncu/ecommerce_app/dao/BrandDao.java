package org.ncu.ecommerce_app.dao;

import org.ncu.ecommerce_app.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand,Long> {

}
