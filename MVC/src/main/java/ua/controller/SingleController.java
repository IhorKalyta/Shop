package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleController {

	@RequestMapping("/single")
	public String showSingle() {
		return "single";
	}
	
		
	
}
