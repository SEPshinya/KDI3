package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	   @Query(value = "SELECT * FROM User AS p WHERE p.address = 1", nativeQuery = true)
	   Page<User> findUsers(String address);
	   public Page<User> findAll(Pageable pageable);
}


