package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.User;
import ua.service.UserService;

public class UserValidator implements Validator{
	
	private UserService userServise;
	
	public UserValidator(UserService userServise) {
		this.userServise=userServise;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if (user.getId() == 0)
			if (userServise.findByLogin(user.getLogin()) != null) {
				errors.rejectValue("login", "", "Login already exists");
			}
		if (user.getId() == 0)
			if (userServise.findByMail(user.getMail()) != null) {
				errors.rejectValue("mail", "", "E-mail already exists");
			}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",
				"Login can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "",
				"E-mail can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
				"Please enter password");
		
	}

}
