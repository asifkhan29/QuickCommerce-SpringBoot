package com.products.images;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageEntityRepository extends JpaRepository<ImageEntity, Integer>{
	
	ImageEntity findByProductsProductId(int i);

}
