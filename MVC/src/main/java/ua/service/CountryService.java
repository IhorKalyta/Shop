package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Country;
import ua.form.CountryFilter;

public interface CountryService {
	
    void delete(String name);
    
    void delete(int id);
	
	void save(Country country);	
	
	Country findByName(String name);
	
	Country findOne(int id);
	
	List<Country> findAll();
	
	Page<Country> findAllPageable(Pageable pageable, CountryFilter form);

	
}
