package ua.service.implementation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.Role;
import ua.entity.User;
import ua.form.ClientFilterForm;
import ua.repository.UserRepository;
import ua.service.UserService;
import ua.service.implementation.specification.UserFilterAdapter;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private MailSender mailSender;

	@Override
	public User findByLogin(String login) {

		return userRepository.findByLogin(login);
	}

	@Override
	public void save(User user) {

		user.setRole(Role.ROLE_USER);
		String pass = user.getPassword();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setLogin(user.getLogin());
		user.setMail(user.getMail());
		user.setConfirmed(user.getConfirmed());

		userRepository.save(user);

		String mailBody = "Congratulation ! You registered on Shop.com" + "\n"
				+ "Login : " + user.getLogin() + "\n" + "E-mail : "
				+ user.getMail() + "\n" + "Password : " + pass
				+ "\n" + "Please click on the confirmation link " + "\n"
				+ "http://www.localhost:8080/confirmation/" + user.getUuid()
				+ "/" + user.getId();
		mailSender.sendMail("Registration confirm", user.getMail(), mailBody);
	}

	@PostConstruct
	public void saveAdmin() {
		User user = userRepository.findOne(1);
		if (user == null) {
			user = new User();
			user.setRole(Role.ROLE_ADMIN);
			user.setPassword(encoder.encode("admin"));
			user.setLogin("admin");
			user.setId(1);
			user.setConfirmed(true);

			userRepository.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		/*
		 * if(Pattern.matches("^[0-9]{1,8}$", login)){ return
		 * userRepository.findOne(Integer.valueOf(login)); }
		 */
		return userRepository.findByLogin(login);
	}

	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public Page<User> findAllPageable(Pageable pageable, ClientFilterForm form) {

		return userRepository.findAll(new UserFilterAdapter(form), pageable);
	}

	@Override
	public User findByMail(String mail) {

		return userRepository.findByMail(mail);
	}

	@Override
	public User findByUuid(String uuid) {

		return userRepository.findByUuid(uuid);
	}

	@Override
	public void confirmEmail(int userId) {
		User user = userRepository.findOne(userId);
		user.setConfirmed(true);
		userRepository.save(user);
	}

}
