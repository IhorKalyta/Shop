package ua.entity;

import javax.persistence.*;

import ua.entity.enums.Gendero;

@Entity
@Table(indexes = { @Index(columnList = "name") })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private double price;
	private int size;
	
	@Lob
	private String description;
	
	private int version;
	
	private String path;

	@Enumerated(EnumType.STRING)	 
	private Gendero gendero;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	private Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	private Color color;

	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	private Gender gender;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	

	public Gendero getGendero() {
		return gendero;
	}

	public void setGendero(Gendero gendero) {
		this.gendero = gendero;
	}
	
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	

	
}
