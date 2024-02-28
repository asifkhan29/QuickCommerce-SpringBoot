package com.SellerRegistrationCode;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Seller.Products.Products;

public interface SellerRegistrationRepository extends JpaRepository<SellerEntity, Integer> {
	
	boolean existsByEmail(String email);
	SellerEntity findByEmail(String email);
	SellerEntity findById(int id);
	List<SellerEntity> findByShopName(String shopName);
	List<SellerEntity> findByShopNameContainingIgnoreCase(String letters);

}
