package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Gender;

public interface GenderService {

	void delete(int id);

	void save(Gender gender);

	Gender findByName(String name);
	
	Gender findOne(int id);

	List<Gender> findAll();
	
	Page<Gender> findAllPageable(Pageable pageable);

}
