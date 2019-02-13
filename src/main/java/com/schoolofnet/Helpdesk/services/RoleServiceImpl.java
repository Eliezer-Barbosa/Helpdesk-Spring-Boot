package com.schoolofnet.Helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.schoolofnet.Helpdesk.models.Role;
import com.schoolofnet.Helpdesk.repositories.RoleRepository;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Role> findAll() {
		return null;
	}

	@Override
	public Role create(Role role) {
		return null;
	}

}
