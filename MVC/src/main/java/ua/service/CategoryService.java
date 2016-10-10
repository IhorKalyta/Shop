package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Category;
import ua.form.CategoryFilter;

public interface CategoryService {

	void delete(String name);

	void delete(int id);

	void save(Category category);

	Category findByName(String name);
	
	Category findOne(int id);

	List<Category> findAll();
	
	Page<Category> findAllPageable(Pageable pageable,CategoryFilter form);

}
