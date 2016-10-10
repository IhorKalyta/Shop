package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Country;
import ua.form.CountryFilter;
import ua.repository.CountryRepository;
import ua.service.CountryService;
import ua.service.implementation.specification.CountryFilterAdapter;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public void delete(String name) {
		countryRepository.delete(name);

	}

	

	@Override
	public Country findByName(String name) {

		return countryRepository.findByName(name);
	}

	@Override
	public List<Country> findAll() {

		return countryRepository.findAll();
	}

	@Override
	public void delete(int id) {
		countryRepository.delete(id);
		
	}

	@Override
	public Country findOne(int id) {
		
		return countryRepository.findOne(id);
	}



	@Override
	public void save(Country country) {
		countryRepository.save(country);
		
	}



	@Override
	public Page<Country> findAllPageable(Pageable pageable,CountryFilter form) {
		
		return countryRepository.findAll(new CountryFilterAdapter(form),pageable);
	}

}
