package com.schoolofnet.Helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.Helpdesk.models.Role;
import com.schoolofnet.Helpdesk.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Role> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Role create(Role role) {
		role.setName(role.getName().toUpperCase());
		Role roleCreated = this.repository.save(role);
		return roleCreated;
	}

	@Override
	public Boolean delete(Long id) {
		Role role = findById(id);
		
		if(role != null) {
			this.repository.delete(role);
			return true;
		}
		
		return false;
	}
	
	private Role findById(Long id) {
		return this.repository.findOne(id);
	}

}
