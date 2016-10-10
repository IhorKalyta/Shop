package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.ProductForm;
import ua.service.ProductService;

public class ProductFormValidator implements Validator{

	private final ProductService productService;
	
	public ProductFormValidator(ProductService productService) {
		this.productService=productService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		
		return ProductForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductForm form = (ProductForm) target;
		if(form.getId()==0)
			if(productService.findByName(form.getName())!=null){
			errors.rejectValue("name", "", "Product already exists");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
	}

	

}
