package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.GenderService;

public class GenderoController {

	@Autowired
	private GenderService genderoService;

	@RequestMapping("/admin/gendero")
	public String show(Model model) {
		model.addAttribute("gendero", genderoService.findAll());
		return "adminGendero";
	}
}
