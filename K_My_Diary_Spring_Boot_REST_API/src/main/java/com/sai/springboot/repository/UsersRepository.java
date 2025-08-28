package com.sai.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sai.springboot.entity.User;

@Repository 
public interface UsersRepository extends JpaRepository<User , Integer>{
	
	
	
	@Query(value = "select * from users u where username=:username Limit 1", nativeQuery = true)
	public User findByUserName(String username);
	 
}
