package com.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{
	
	List<ReviewEntity> findByProductsProductId(int i);

}
