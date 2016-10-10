package ua.service.implementation.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Color;
import ua.service.ColorService;


public class ColorFormValidator implements Validator{

	private ColorService colorService;
	
	
	
	public ColorFormValidator(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Color.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Color color= (Color) target;
		if(color.getId()==0)if(colorService.findByName(color.getName())!=null){
			errors.rejectValue("name", "", "Color already exists");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
	}

}
