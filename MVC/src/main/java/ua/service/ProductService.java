package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Country;
import ua.entity.Gender;
import ua.entity.Product;
import ua.form.ProductFilterForm;
import ua.form.ProductForm;

public interface ProductService {

	void delete(String name);

	void delete(int id);

	void save(ProductForm form);

	Product findByName(String name);

	ProductForm findForForm(int id);

	Product findBySize(int size);

	Product findByPrice(int price);
	
	Product findByGender(Gender gender);
	
	Product findByCountry(Country country);

	List<Product> findAll();

	Page<Product> findAllPageable(Pageable pageable,ProductFilterForm form);
	
	Product findOne(int id);

}
