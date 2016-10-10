package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>,JpaSpecificationExecutor<Category>{

	@Modifying
	@Query("DELETE FROM Category c WHERE c.name=:name")
	void deleteByName(@Param("name") String name);
	Category findByName(String name);

	

}
