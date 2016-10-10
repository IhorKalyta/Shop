package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Type;
import ua.form.TypeFilter;

public interface TypeService {

	void delete(String name);
	
	void delete(int id);

	void save(Type type);

	Type findByName(String name);
	
	Type findOne(int id);

	List<Type> findAll();
	
	Page<Type> findAllPageable(Pageable pageable,TypeFilter form);

}
