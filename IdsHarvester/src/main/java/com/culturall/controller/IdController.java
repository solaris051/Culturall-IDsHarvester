package com.culturall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.culturall.service.IdService;

@Controller
public class IdController {
	
	@Autowired
	IdService idService;
	
	@RequestMapping(value="/")
	public String doSmth() {
		System.out.println("doer doing...");
		return "home";
	}
/*
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String findPageById(@PathVariable String id, Model model) {
		Integer idForLookUp = null;
		try {
			idForLookUp = Integer.parseInt(id);
			String matchedUrl = idService.getUrlByTranslateId(Long.parseLong(id));
			model.addAttribute("matchedUrl", matchedUrl);
			return "home";
		} catch (NumberFormatException nfe) {
			model.addAttribute("matchedUrl", "wrong number format");
			return "home";
		}
	}
	*/
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody String findPageById(@PathVariable String id, Model model) {
		Integer idForLookUp = null;
		try {
			idForLookUp = Integer.parseInt(id);
			String matchedUrl = idService.getUrlByTranslateId(Long.parseLong(id));
			model.addAttribute("matchedUrl", matchedUrl);
			return matchedUrl;
		} catch (NumberFormatException nfe) {
			model.addAttribute("matchedUrl", "wrong number format");
			return "URL was not found";
		}
	}
	
	@RequestMapping(value="idHarvester")
	public void  harvestIds() {
		System.out.println("start harvesting...");
		idService.harvestIds();
	}
	
/*	
	@RequestMapping(value="home1")
	public String home1(Model model) {
		System.out.println("message from Roster/home");
		model.addAttribute("arg", "message from Home " + idService.getValue());
		return "home1";
	}
	
	@RequestMapping(value="home2")
	public String home2(Model model) {
		System.out.println("message from Roster/home2");
		model.addAttribute("arg", "message form Home2 " + idService.getValue());
		return "home1";
	}
*/
}
