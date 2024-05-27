package org.ncu.ecommerce_app.service;

import java.util.List;

import org.ncu.ecommerce_app.dao.BrandDao;
import org.ncu.ecommerce_app.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Long id, Brand brand) {
        Brand existingBrand = brandRepository.findById(id).orElse(null);
        if (existingBrand != null) {
            existingBrand.setName(brand.getName());
            // Set other fields if necessary
            return brandRepository.save(existingBrand);
        }
        return null;
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}

