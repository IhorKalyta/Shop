package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Type;
import ua.form.TypeFilter;
import ua.repository.TypeRepository;
import ua.service.TypeService;
import ua.service.implementation.specification.TypeFilterAdapter;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;

	@Override
	public void delete(String name) {
		typeRepository.delete(name);

	}

	

	@Override
	public Type findByName(String name) {

		return typeRepository.findByName(name);
	}

	@Override
	public List<Type> findAll() {

		return typeRepository.findAll();
	}

	@Override
	public void delete(int id) {
		typeRepository.delete(id);
		
	}



	@Override
	public void save(Type type) {
	  typeRepository.save(type);
		
	}



	@Override
	public Type findOne(int id) {
		
		return typeRepository.findOne(id);
	}



	@Override
	public Page<Type> findAllPageable(Pageable pageable,TypeFilter form) {
		
		return typeRepository.findAll(new TypeFilterAdapter(form),pageable);
	}

}
