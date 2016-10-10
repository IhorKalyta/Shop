package ua.service.implementation.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Country;
import ua.service.CountryService;
public class CountryFormValidator implements Validator{

	private final CountryService countryService;
	
	
	
	public CountryFormValidator(CountryService countryService) {
		
		this.countryService = countryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Country.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Country country = (Country) target;
		if(country.getId()==0)if(countryService.findByName(country.getName())!=null){
			errors.rejectValue("name", "", "Country already exists");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
	}

}
