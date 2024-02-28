package com.Seller.Products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	List<Products> findBySellerEntityId(int id);
	List<Products> findByProductName(String productName);
	Products findById(int id);
	Products findByProductId(Products pro);
    List<Products> findByProductNameContainingIgnoreCase(String letters);


}
