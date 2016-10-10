package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Gender;
import ua.repository.GenderRepository;
import ua.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {

	@Autowired
	private GenderRepository genderRepository;

	@Override
	public void delete(int id) {
		genderRepository.delete(id);

	}

	@Override
	public Gender findByName(String name) {

		return genderRepository.findByName(name);
	}

	@Override
	public List<Gender> findAll() {

		return genderRepository.findAll();
	}

	@Override
	public void save(Gender gender) {
		genderRepository.save(gender);
		
	}

	@Override
	public Gender findOne(int id) {
		
		return genderRepository.findOne(id);
	}

	@Override
	public Page<Gender> findAllPageable(Pageable pageable) {
		
		return genderRepository.findAll(pageable);
	}

}
