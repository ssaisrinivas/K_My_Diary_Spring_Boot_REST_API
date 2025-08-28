package com.sai.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.springboot.entity.User;
import com.sai.springboot.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public UsersRepository getusersRepository() {
		return usersRepository;
	}

	public void setusersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public User save(User user) {
		return usersRepository.save(user);
	}

	@Override
	public User update(User user) {
		return usersRepository.save(user);
	}

	@Override
	public void delete(User user) {
		usersRepository.delete(user);
	}

	@Override
	public User findById(int id) {
		return usersRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return usersRepository.findAll();
	}

	
	@Override
	public User findByUserName(String username) {
		return usersRepository.findByUserName(username);
	}
	 
	

}
