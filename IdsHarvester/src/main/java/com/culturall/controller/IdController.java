package com.culturall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.culturall.service.IdService;

@Controller
public class IdController {
	
	@Autowired
	IdService idService;
	
	@RequestMapping(value="home")
	public String home(Model model) {
		System.out.println("message from Roster/home");
		model.addAttribute("arg", "message from Home " + idService.getValue());
		return "home";
	}
	
	@RequestMapping(value="home2")
	public String home2(Model model) {
		System.out.println("message from Roster/home2");
		model.addAttribute("arg", "message form Home2 " + idService.getValue());
		return "home";
	}
}
