package com.schoolofnet.Helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.Helpdesk.models.Ticket;
import com.schoolofnet.Helpdesk.services.TicketService;
import com.schoolofnet.Helpdesk.services.UserService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	public TicketController(TicketService ticketService, UserService userService) {
		this.ticketService = ticketService;
		this.userService = userService;
	}
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", this.ticketService.findAll());
		model.addAttribute("userLoggedIn", this.userService.findCurrentUser());
		return "ticket/index";
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ticket", this.ticketService.show(id));
		return "ticket/show";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model = this.ticketService.findAllTechnician(model);
		model.addAttribute("ticket", this.ticketService.show(id));
		
		return "ticket/edit";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model = this.ticketService.findAllTechnician(model);
		model.addAttribute("ticket", new Ticket());
		
		return "ticket/create";
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "ticket/create";
		}
		
		this.ticketService.create(ticket);
		return "redirect:/tickets";
	}
	
	@PutMapping("{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "ticket/edit";
		}
		
		this.ticketService.update(id, ticket);
		
		return "redirect:/tickets";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		this.ticketService.delete(id);
		
		return "redirect:/tickets";
	}

}
