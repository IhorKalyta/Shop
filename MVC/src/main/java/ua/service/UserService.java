package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.User;
import ua.entity.VerificationToken;
import ua.form.ClientFilterForm;

public interface UserService {
	
	User getUser(String verificationToken);

	User findByLogin(String login);

	User findById(int id);
	
	User findByMail(String mail);
	
	List<User>findAll();
	
	Page<User> findAllPageable(Pageable pageable, ClientFilterForm form);

	void save(User user);
	
	void createVerificationTokenForUser(User user, String token);
	
	VerificationToken getVerificationToken(String VerificationToken);
	
	String validateVerificationToken(String token);
}
