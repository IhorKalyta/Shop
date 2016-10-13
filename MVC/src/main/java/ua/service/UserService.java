package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.User;
import ua.form.ClientFilterForm;

public interface UserService {

	User findByLogin(String login);

	User findById(int id);

	User findByMail(String mail);
	
	User findByUuid (String uuid);

	List<User> findAll();

	Page<User> findAllPageable(Pageable pageable, ClientFilterForm form);

	void save(User user);
	
	void confirmEmail(int userId);

}
