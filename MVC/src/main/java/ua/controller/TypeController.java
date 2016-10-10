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

import ua.entity.Type;
import ua.form.TypeFilter;
import ua.service.TypeService;
import ua.service.implementation.validator.TypeFormValidator;

@Controller
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@InitBinder("type")
	protected void initBinder(WebDataBinder binder){
	  
	   binder.setValidator(new TypeFormValidator(typeService));
	}
	
	@ModelAttribute("type")
	public Type getType(){
		return new Type();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter() {
		return new TypeFilter();
	}
	@RequestMapping("/admin/type")
	public String showType(Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")TypeFilter form) {
		model.addAttribute("types", typeService.findAllPageable(pageable,form));
		return "adminType";
	}
	
	@RequestMapping("/admin/type/delete/{id}")
	public String deleteType(@PathVariable int id, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")TypeFilter form){
		typeService.delete(id);
		return "redirect:/admin/type"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/type/update/{id}")
	public String updateType(@PathVariable int id, Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")TypeFilter form) {
		model.addAttribute("type", typeService.findOne(id));
		model.addAttribute("types", typeService.findAllPageable(pageable,form));
		return "adminType";
	}
	
	@RequestMapping(value= "/admin/type", method=RequestMethod.POST)
	public String saveType(@ModelAttribute("type") @Valid Type type,  BindingResult br,Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter")TypeFilter form){
		if(br.hasErrors()){
			model.addAttribute("types", typeService.findAllPageable(pageable,form));
			return "adminType";
		}
		typeService.save(type);
		return "redirect:/admin/type"+getParams(pageable, form);
	}
	
	private String getParams(Pageable pageable, TypeFilter form) {
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
		
		return buffer.toString();
	}
}
