package com.DropShipperRegistrationCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropShipperRepository extends JpaRepository<DropShipperEntity, Integer>{
	boolean existsByEmail(String email);
	DropShipperEntity findByEmail(String email);

}
