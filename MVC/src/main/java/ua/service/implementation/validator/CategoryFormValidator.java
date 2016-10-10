package ua.service.implementation.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Category;
import ua.service.CategoryService;

public class CategoryFormValidator implements Validator{

	private CategoryService categoryService;
	
	
	
	public CategoryFormValidator(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		if(category.getId()==0)if(categoryService.findByName(category.getName())!=null){
			errors.rejectValue("name", "", "Category already exists");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
	}

}
