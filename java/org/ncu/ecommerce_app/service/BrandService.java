package org.ncu.ecommerce_app.service;

import java.util.List;

import org.ncu.ecommerce_app.entity.Brand;

public interface BrandService {
	  List<Brand> getAllBrands();
	    Brand getBrandById(Long id);
	    Brand createBrand(Brand brand);
	    Brand updateBrand(Long id, Brand brand);
	    void deleteBrand(Long id);
}
