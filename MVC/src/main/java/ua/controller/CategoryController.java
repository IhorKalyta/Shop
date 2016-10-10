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

import ua.entity.Category;
import ua.form.CategoryFilter;
import ua.service.CategoryService;
import ua.service.implementation.validator.CategoryFormValidator;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@InitBinder("category")
	protected void initBinder(WebDataBinder binder){
	  
	   binder.setValidator(new CategoryFormValidator(categoryService));
	}
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	@ModelAttribute("filter")
	public CategoryFilter getFilter() {
		return new CategoryFilter();
	}
	
	@RequestMapping("/admin/category")
	public String showCategory(Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") CategoryFilter form) {
		model.addAttribute("categories", categoryService.findAllPageable(pageable,form));
		return "adminCategory";
	}
	
	@RequestMapping("/admin/category/delete/{id}")
	public String deleteCountry(@PathVariable int id,@PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") CategoryFilter form){
		categoryService.delete(id);
		return "redirect:/admin/category"+  getParams(pageable, form);
	}
	
	@RequestMapping(value= "/admin/category", method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") @Valid Category category,  BindingResult br,Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") CategoryFilter form){
		if(br.hasErrors()){
			model.addAttribute("categories", categoryService.findAllPageable(pageable,form));
			return "adminCategory";
		}
		categoryService.save(category);
		return "redirect:/admin/category"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/category/update/{id}")
	public String updateCategory(@PathVariable int id, Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") CategoryFilter form) {
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("categories", categoryService.findAllPageable(pageable,form));
		return "adminCategory";
	}
	
	private String getParams(Pageable pageable, CategoryFilter form) {
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
