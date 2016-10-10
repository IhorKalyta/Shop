package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Country;
import ua.entity.Gender;
import ua.entity.Type;
import ua.entity.enums.Gendero;
import ua.form.ProductFilterForm;
import ua.service.CategoryService;
import ua.service.ColorService;
import ua.service.CountryService;
import ua.service.GenderService;
import ua.service.ProductService;
import ua.service.TypeService;
import ua.service.implementation.editor.CategoryEditor;
import ua.service.implementation.editor.ColorEditor;
import ua.service.implementation.editor.CountryEditor;
import ua.service.implementation.editor.GenderEditor;
import ua.service.implementation.editor.TypeEditor;
import ua.service.implementation.validator.ProductFormValidator;

@Controller
public class ProdController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ColorService colorService;

	@Autowired
	private GenderService genderService;

	@Autowired
	private TypeService typeService;
	
	@InitBinder("form")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor(
				countryService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(
				categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Gender.class, new GenderEditor(
				genderService));
		binder.registerCustomEditor(Type.class, new TypeEditor(typeService));
		
		binder.setValidator(new ProductFormValidator(productService));
	}

	
	
	@ModelAttribute("filter")
	public ProductFilterForm getFilter() {
		return new ProductFilterForm();
	}

	@RequestMapping("/product")
	public String showProduc(Model model, @PageableDefault(6) Pageable pageable,@ModelAttribute(value = "filter") ProductFilterForm filter) {
		model.addAttribute("product", productService.findAllPageable(pageable,filter));
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("color", colorService.findAll());
		model.addAttribute("gender", genderService.findAll());
		model.addAttribute("types", typeService.findAll());
		model.addAttribute("gendero",Gendero.values());

		return "product";
	}
	

	@RequestMapping(value = "/single/{id}")
	public String showSingle(Model model,@PathVariable int id,@ModelAttribute(value = "filter") ProductFilterForm filter) {
		model.addAttribute("product", productService.findOne(id));		

		return "single";
	}
	@RequestMapping("/product/{category}")
	public String showCategory(Model model){
		model.addAttribute("product", productService.findAll());
		model.addAttribute("category",categoryService.findAll());
		return "product";
	}
	
}
