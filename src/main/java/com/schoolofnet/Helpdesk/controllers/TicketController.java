package com.schoolofnet.Helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.Helpdesk.models.Role;
import com.schoolofnet.Helpdesk.models.Ticket;
import com.schoolofnet.Helpdesk.services.RoleService;
import com.schoolofnet.Helpdesk.services.TicketService;
import com.schoolofnet.Helpdesk.services.UserService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	//private final Long ROLE_ID = 4L;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	@GetMapping
	public String create(Model model) {
		model.addAttribute("ticket", new Ticket());
		
		Role adminRole = this.roleService.findByName("ADMIN");
		model.addAttribute("techs", this.userService.findAllWhereRoleEquals(adminRole.getId()));
		//model.addAttribute("techs", this.userService.findAllWhereRoleEquals(ROLE_ID));
		return "ticket/create";
	}

}
