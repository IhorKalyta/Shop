package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import ua.entity.Gender;
import ua.service.GenderService;

@Controller
public class GenderController {
	@Autowired
	private GenderService genderService;

	@ModelAttribute("gender")
	public Gender getGender(){
		return new Gender();
	}
	
	@RequestMapping("/admin/gender")
	public String showGender(Model model,  @PageableDefault(5) Pageable pageable) {
		model.addAttribute("genders", genderService.findAllPageable(pageable));
		return "adminGender";
	}

	@RequestMapping(value = "/admin/gender", method = RequestMethod.POST)
	public String saveGender(@ModelAttribute("gender") Gender gender, @PageableDefault(5) Pageable pageable) {
		genderService.save(gender);
		return "redirect:/admin/gender";
	}
	
	@RequestMapping("/admin/gender/update/{id}")
	public String updateGender(@PathVariable int id, Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("gender", genderService.findOne(id));
		model.addAttribute("genders", genderService.findAllPageable(pageable));

		return "adminGender";
	}
	
}
