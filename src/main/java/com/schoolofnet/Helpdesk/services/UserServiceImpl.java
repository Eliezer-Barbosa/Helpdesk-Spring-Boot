package com.schoolofnet.Helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.Helpdesk.models.User;
import com.schoolofnet.Helpdesk.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User create(User user) {
		return this.repository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		User user = findById(id);
		
		if(user != null) {
			this.repository.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(Long id, User user) {
		return null;
	}
	
	private User findById(Long id) {
		return this.repository.findOne(id);
	}

}
