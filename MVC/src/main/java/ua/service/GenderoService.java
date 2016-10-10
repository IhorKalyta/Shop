package ua.service;

import java.util.List;


import ua.entity.enums.Gendero;

public interface GenderoService {

	Gendero findOne(int id);
	
	List<Gendero> findAll();

	void save(Gendero gendero);

}
