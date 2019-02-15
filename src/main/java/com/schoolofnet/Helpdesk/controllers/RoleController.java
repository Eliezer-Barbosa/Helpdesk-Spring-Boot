package com.schoolofnet.Helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.Helpdesk.models.Role;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@GetMapping
	public String index(Model model) {
		return "roles/index";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("role", new Role());
		return "roles/create";
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "redirect:/roles/new";
		}
		return null;
	}
	
	@DeleteMapping
	public String delete(Model model) {
		return null;
	}

}
