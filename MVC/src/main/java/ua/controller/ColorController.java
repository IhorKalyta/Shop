package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import ua.entity.Color;
import ua.form.ColorFilter;
import ua.service.ColorService;
import ua.service.implementation.validator.ColorFormValidator;

@Controller
public class ColorController {
	@Autowired
	private ColorService colorService;

	@InitBinder("color")
	protected void initBinder(WebDataBinder binder){
	  
	   binder.setValidator(new ColorFormValidator(colorService));
	}
	
	@ModelAttribute("color")
	public Color getColor() {
		return new Color();
	}
	
	@ModelAttribute("filter")
	public ColorFilter getFilter() {
		return new ColorFilter();
	}

	@RequestMapping("/admin/color")
	public String showColor(Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") ColorFilter form) {
		model.addAttribute("colors", colorService.findAllPageable(pageable,form));
		return "adminColor";
	}

	@RequestMapping("/admin/color/delete/{id}")
	public String deleteColor(@PathVariable int id, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")ColorFilter form) {
		colorService.delete(id);
		return "redirect:/admin/color"+getParams(pageable, form);
	}

	@RequestMapping("/admin/color/update/{id}")
	public String updateColor(@PathVariable int id, Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")ColorFilter form) {
		model.addAttribute("color", colorService.findOne(id));
		model.addAttribute("colors", colorService.findAllPageable(pageable,form));
		return "adminColor";
	}

	@RequestMapping(value = "/admin/color", method = RequestMethod.POST)
	public String saveColor(@ModelAttribute("color") @Valid Color color, BindingResult br,Model model,@PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")ColorFilter form) {
		if(br.hasErrors()){
			model.addAttribute("colors", colorService.findAllPageable(pageable,form));
			return "adminColor";
		}
		colorService.save(color);
		return "redirect:/admin/color"+getParams(pageable, form);
	}

	private String getParams(Pageable pageable, ColorFilter form) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber() + 1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if (pageable.getSort() != null) {
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order) -> {
				buffer.append(order.getProperty());
				if (order.getDirection() != Direction.ASC)
					buffer.append(",desc");
			});
		}
		//buffer.append("&search=");
		//buffer.append(form.getSearch());
		return buffer.toString();
	}
}
