package com.schoolofnet.Helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.Helpdesk.models.Ticket;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@GetMapping
	public String create(Model model) {
		model.addAttribute("ticket",new Ticket());
		return "ticket/create";
	}

}
