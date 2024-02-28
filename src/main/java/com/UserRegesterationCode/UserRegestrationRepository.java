package com.UserRegesterationCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegestrationRepository extends JpaRepository<UserRegester,Integer> {
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);
	UserRegester findByEmail(String email);
	boolean findByName(String name);
	UserRegester findById(int id);

}
