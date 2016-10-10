package ua.service.implementation;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.service.FileWriter.Folder;
import ua.entity.Country;
import ua.entity.Gender;
import ua.entity.Product;
import ua.form.ProductFilterForm;
import ua.form.ProductForm;
import ua.repository.CategoryRepository;
import ua.repository.ColorRepository;
import ua.repository.CountryRepository;
import ua.repository.GenderRepository;
import ua.repository.ProductRepository;
import ua.repository.TypeRepository;
import ua.service.FileWriter;
import ua.service.ProductService;
import ua.service.implementation.specification.ProductFilterAdapter;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private GenderRepository genderRepository;
	@Autowired
	private FileWriter fileWriter;
	
	
	@Override
	public List<Product> findAll() {

		return productRepository.findAll();
	}

	@Override
	public void delete(String name) {
		productRepository.delete(name);
	}

	@Override
	public Product findByName(String name) {

		return productRepository.findByName(name);
	}

	@Override
	public void delete(int id) {
		productRepository.delete(id);

	}

	@Override
	public void save(ProductForm form) {
		Product product = new Product();
		product.setId(form.getId());
		product.setCountry(form.getCountry());
		product.setColor(form.getColor());
		product.setGender(form.getGender());
		product.setType(form.getType());
		product.setCategory(form.getCategory());
		product.setName(form.getName());
		product.setPrice(form.getPrice());
		product.setSize(form.getSize());
		product.setDescription(form.getDescription());
		product.setGendero(form.getGendero());
		
		product.setPath(form.getPath());
		product.setVersion(form.getVersion());

		productRepository.saveAndFlush(product);
		
		String extension = fileWriter.write(Folder.PRODUCT, form.getFile(), product.getId());
		if(extension!=null){
			product.setVersion(form.getVersion()+1);
			product.setPath(extension);
			productRepository.save(product);
}

	}

	@Override
	public ProductForm findForForm(int id) {
		Product product = productRepository.findOneCountryInited(id);
		
		ProductForm form = new ProductForm();
		
		form.setId(id);
		form.setCountry(product.getCountry());
		form.setColor(product.getColor());
		form.setGender(product.getGender());
		form.setType(product.getType());
		form.setCategory(product.getCategory());
		form.setName(product.getName());
		form.setSize(product.getSize());
		form.setPrice(product.getPrice());
		form.setGendero(product.getGendero());
		form.setDescription(product.getDescription());

		return form;
	}

	@Override
	public Product findBySize(int size) {
		
		return productRepository.findBySize(size);
	}

	@Override
	public Product findByPrice(int price) {
		
		return productRepository.findByPrice(price);
	}

	@Override
	public Page<Product> findAllPageable(Pageable pageable,ProductFilterForm form) {
		
		
		return productRepository.findAll(new ProductFilterAdapter(form),pageable);
	}

	@Override
	public Product findByCountry(Country country) {
		
		return productRepository.findByCountry(country);
	}

	@Override
	public Product findOne(int id) {
		
		return productRepository.findOne(id);
	}

	@Override
	public Product findByGender(Gender gender) {
	
		return productRepository.findByGender(gender);
	}

	

}
