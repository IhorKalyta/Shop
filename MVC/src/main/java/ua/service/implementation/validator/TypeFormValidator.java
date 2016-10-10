package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Type;
import ua.service.TypeService;

public class TypeFormValidator implements Validator{

	private TypeService typeService;
	
	
	public TypeFormValidator(TypeService typeService) {
		super();
		this.typeService = typeService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Type.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Type type = (Type)target;
		if(type.getId()==0)if(typeService.findByName(type.getName())!=null){
			errors.rejectValue("name", "", "Type already exists");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
	}

}
