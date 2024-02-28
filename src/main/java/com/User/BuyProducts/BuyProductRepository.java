package com.User.BuyProducts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyProductRepository extends JpaRepository<BuyProductsEntity, Integer> {
	
	List<BuyProductsEntity> findByUserRegesterId(int id);
	List<BuyProductsEntity> findBySellerEntityId(int id);
	BuyProductsEntity findById(int id);

}
