package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer>,JpaSpecificationExecutor<Type>{

	Type findByName(String name);

	default void delete(String name){
		delete(findByName(name));
	}
}
