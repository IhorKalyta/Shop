package ua.service.implementation;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

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
import ua.entity.VerificationToken;
import ua.form.ClientFilterForm;
import ua.repository.UserRepository;
import ua.repository.VerificationTokenRepository;
import ua.service.UserService;
import ua.service.implementation.specification.UserFilterAdapter;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private MailSender mail;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	public static final String TOKEN_INVALID = "invalidToken";
	public static final String TOKEN_EXPIRED = "expired";
	private static final String TOKEN_VALID = "valid";

	@Override
	public User findByLogin(String login) {

		return userRepository.findByLogin(login);
	}

	@Override
	public void save(User user) {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		mail.sendMail("Congratulation", user.getMail(), "Welcome to our shop");
		userRepository.save(user);
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
			user.setEnabled(true);

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
	public void createVerificationTokenForUser(User user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
		tokenRepository.save(myToken);

	}

	@Override
	public VerificationToken getVerificationToken(String VerificationToken) {

		return tokenRepository.findByToken(VerificationToken);
	}

	@Override
	public String validateVerificationToken(String token) {

		final VerificationToken verificationToken = tokenRepository
				.findByToken(token);
		if (verificationToken == null) {
			return TOKEN_INVALID;
		}

		final User user = verificationToken.getUser();
		final Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime()
				.getTime()) <= 0) {
			tokenRepository.delete(verificationToken);
			return TOKEN_EXPIRED;
		}

		user.setEnabled(true);
		// tokenRepository.delete(verificationToken);
		userRepository.save(user);
		return TOKEN_VALID;
	}

	@Override
	public User getUser(String verificationToken) {
		VerificationToken token = tokenRepository.findByToken(verificationToken);
        if (token != null) {
            return token.getUser();
        }
        return null;
	}

}
