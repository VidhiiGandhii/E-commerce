package org.ncu.ecommerce_app.dao;

import java.util.List;

import org.ncu.ecommerce_app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends  JpaRepository<Review, Long> {

	   List<Review> findAll();
	    void deleteById(Long id);
	    List<Review> findByProductId(Long productId);
	}
