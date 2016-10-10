package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer>{

	Gender findByName(String name);

}
