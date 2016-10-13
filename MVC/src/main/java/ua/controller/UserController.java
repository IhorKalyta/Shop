package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.User;
import ua.form.ClientFilterForm;
import ua.service.UserService;
import ua.service.implementation.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messages;

	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {

		binder.setValidator(new UserValidator(userService));
	}

	@RequestMapping("/admin/user")
	public String showUser(Model model, @PageableDefault(5) Pageable pageable,
			@ModelAttribute(value = "filter") ClientFilterForm form) {
		model.addAttribute("users", userService.findAllPageable(pageable, form));
		return "adminUser";
	}

	@ModelAttribute("user")
	public User getForm() {
		return new User();
	}

	@RequestMapping("/registration")
	public String register() {
		return "registration";
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") @Valid User user,
			BindingResult br) {
		if (br.hasErrors()) {
			return "registration";
		}
		userService.save(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/confirmation/{UUID}/{id}")
	public String login(@PathVariable("UUID")String uuid,@PathVariable("id") int id, @ModelAttribute("logForm") User user){
		if(userService.findById(id).getUuid().equals(userService.findByUuid(uuid).getUuid())) {
			userService.confirmEmail(id);
			return "redirect:/login";
		}
		
		return "registration";
	}

}
