package com.sai.springboot.service;

import java.util.List;

import com.sai.springboot.entity.User;


public interface UsersService {
	
	public User save(User user) ;

	public User update(User user);

	public void delete(User user);
	
	public User findById(int id);
	
    public User findByUserName(String username) ; 
	
	public List<User> findAll() ;

}
