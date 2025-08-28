package com.sai.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sai.springboot.Application;
import com.sai.springboot.entity.User;
import com.sai.springboot.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Application application;

	@Autowired
	UsersService usersService;

	UserController(Application application) {
		this.application = application;
	}

	@GetMapping("/")
	public List<User> findAllUsers() {
		return usersService.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return usersService.findById(id);
	}

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return usersService.save(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") int id) {

		User dbUser = usersService.findById(id);

		dbUser.setUsername(user.getUsername());
		dbUser.setPassword(user.getPassword());
		// dbUser.setId(id);
		return usersService.save(dbUser);

	}

	@PatchMapping("/{id}")
	public User partialUpdateUser(@RequestBody User user, @PathVariable("id") int id) {

		String userName = user.getUsername();
		String password = user.getPassword();

		User dbUser = usersService.findById(id);

		if (userName != null && userName.length() > 0)
			dbUser.setUsername(user.getUsername());

		if (password != null && password.length() > 0)
			dbUser.setPassword(user.getPassword());

		// dbUser.setId(id);
		return usersService.save(dbUser);

	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {

		User dbUser = usersService.findById(id);
		usersService.delete(dbUser);

	}

}
