package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(nativeQuery = true, value = "select count(id) from user where email_address = ?1")
	Integer countEmail(String email);
	
	User findByUsername(String username);
}
