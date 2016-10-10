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
import ua.entity.Color;
import ua.entity.Country;
import ua.entity.Gender;
import ua.entity.Type;
import ua.entity.enums.Gendero;
import ua.form.ProductFilterForm;
import ua.form.ProductForm;
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
public class ProductController {

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

	@ModelAttribute("form")
	public ProductForm getForm() {
		return new ProductForm();
	}
	
	@ModelAttribute("genderos")
	public Gendero[] getGendero(){
		return Gendero.values();
	}
	
	@ModelAttribute("filter")
	public ProductFilterForm getFilter() {
		return new ProductFilterForm();
	}

	@RequestMapping("/admin/product")
	public String showProduct(Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") ProductFilterForm filter) {
		model.addAttribute("product", productService.findAllPageable(pageable,filter));
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("color", colorService.findAll());
		model.addAttribute("gender", genderService.findAll());
		model.addAttribute("types", typeService.findAll());
		model.addAttribute("gendero",Gendero.values());

		return "adminProduct";
	}

	@RequestMapping(value = "/admin/product", method = RequestMethod.POST)
	public String save(@ModelAttribute("form") @Valid ProductForm productForm, BindingResult br, Model model, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") ProductFilterForm filter) {
		if(br.hasErrors()){
			model.addAttribute("product", productService.findAllPageable(pageable,filter));
			model.addAttribute("countries", countryService.findAll());
			model.addAttribute("category", categoryService.findAll());
			model.addAttribute("color", colorService.findAll());
			model.addAttribute("gender", genderService.findAll());
			model.addAttribute("types", typeService.findAll());
			model.addAttribute("genderos", Gendero.values());

			return "adminProduct";
		}
		productService.save(productForm);
		return "redirect:/admin/product"+getParams(pageable, filter);
	}

	@RequestMapping(value = "/admin/product/update/{id}")
	public String update(Model model, @PathVariable int id, @PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") ProductFilterForm filter) {
		
		model.addAttribute("product", productService.findAllPageable(pageable,filter));
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("color", colorService.findAll());
		model.addAttribute("gender", genderService.findAll());
		model.addAttribute("types", typeService.findAll());
		model.addAttribute("genderos");
		model.addAttribute("form", productService.findForForm(id));

		return "adminProduct";
	}

	@RequestMapping(value = "/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable int id,@PageableDefault(5) Pageable pageable,@ModelAttribute(value = "filter") ProductFilterForm filter) {
		productService.delete(id);
		return "redirect:/admin/product"+  getParams(pageable, filter);
	}
	private String getParams(Pageable pageable, ProductFilterForm form) {
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
		
		for(Integer i : form.getCountryIds()){
			buffer.append("&countryIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getColorIds()){
			buffer.append("&colorIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getCategoryIds()){
			buffer.append("&categoryIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getGenderIds()){
			buffer.append("&genderIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getTypeIds()){
			buffer.append("&typeIds=");
			buffer.append(i.toString());
		}
		buffer.append("&search=");
		buffer.append(form.getSearch());
		return buffer.toString();
	}
}
