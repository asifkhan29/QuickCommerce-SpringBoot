package com.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Integer> {
	
	List<CartEntity> findByUserRegesterId(int id);
	CartEntity findByProductsProductId(int id);
    CartEntity  findByUserRegesterIdAndProductsProductId(int userId,int productId);
    
    
}
