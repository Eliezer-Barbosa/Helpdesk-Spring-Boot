package com.schoolofnet.Helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.schoolofnet.Helpdesk.models.User;
import com.schoolofnet.Helpdesk.repositories.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User create(User user) {
		return this.repository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

	@Override
	public Boolean update(Long id, User user) {
		return null;
	}

}
