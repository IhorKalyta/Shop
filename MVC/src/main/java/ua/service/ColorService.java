package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Color;
import ua.form.ColorFilter;


public interface ColorService {

	void delete(String name);
	
	void delete(int id);

	void save(Color color);

	Color findByName(String name);
	
	Color findOne(int id);

	List<Color> findAll();
	
	Page<Color> findAllPageable(Pageable pageable,ColorFilter form);

}
