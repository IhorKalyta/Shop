package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Country;
import ua.entity.Gender;
import ua.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>,
		JpaSpecificationExecutor<Product> {

	@Modifying
	@Query("DELETE FROM Product p WHERE p.name=:name")
	void deleteByName(@Param("name") String name);

	Product findByName(String name);

	Product findBySize(int size);

	Product findByPrice(int price);
	
	

	default void delete(String name) {
		delete(findByName(name));
	}

	@Query("SELECT p FROM Product p LEFT JOIN FETCH "
			+ "p.country LEFT JOIN FETCH p.category LEFT JOIN FETCH p.color LEFT JOIN FETCH p.gender LEFT JOIN FETCH p.type")
	List<Product> findAll();

	@Query(value = "SELECT p FROM Product p LEFT JOIN FETCH p.country LEFT JOIN FETCH p.color LEFT JOIN FETCH p.category LEFT JOIN FETCH p.type LEFT JOIN FETCH p.gender", countQuery = "SELECT count(p.id) FROM Product p")
	Page<Product> findAll(Pageable pageable);

	@Query("SELECT p FROM Product p LEFT JOIN FETCH p.country LEFT JOIN FETCH p.color LEFT JOIN FETCH p.category LEFT JOIN FETCH p.type LEFT JOIN FETCH p.gender WHERE p.id=:id")
	Product findOneCountryInited(@Param("id") int id);

	@Query("SELECT p FROM Product p LEFT JOIN FETCH " + "p.country")
	Product findByCountry(Country country);
	
	@Query("SELECT p FROM Product p LEFT JOIN FETCH " + "p.gender")
	Product findByGender(Gender gender);


}
