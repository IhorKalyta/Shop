package ua.form;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import ua.entity.enums.Gendero;


public class ProductFilterForm {

	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	private String name;
	
	private String min = "";
	
	private String max = "";
	
	private int minInt = 0;
	
	private int maxInt = 0;
	
	private static final Pattern p = Pattern.compile("^[0-9]{1,9}$");
	
	
	
	private List<Integer>countryIds = new ArrayList<Integer>();
	private List<Integer>colorIds = new ArrayList<Integer>();
	private List<Integer>categoryIds = new ArrayList<Integer>();
	private List<Integer>typeIds= new ArrayList<Integer>();
	private List<Integer>genderIds= new ArrayList<Integer>();
	private List<Gendero> genderoIds = new ArrayList<>();  
	
	
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		
		if(p.matcher(min).matches()) minInt = Integer.valueOf(min);

		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		if(p.matcher(max).matches()) maxInt = Integer.valueOf(max);

		this.max = max;
	}
	
	
	public int getMinInt() {
		return minInt;
	}
	public void setMinInt(int minInt) {
		this.minInt = minInt;
	}
	public int getMaxInt() {
		return maxInt;
	}
	public void setMaxInt(int maxInt) {
		this.maxInt = maxInt;
	}
	public List<Integer> getCountryIds() {
		return countryIds;
	}
	public void setCountryIds(List<Integer> countryIds) {
		this.countryIds = countryIds;
	}
	public List<Integer> getColorIds() {
		return colorIds;
	}
	public void setColorIds(List<Integer> colorIds) {
		this.colorIds = colorIds;
	}
	public List<Integer> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public List<Integer> getTypeIds() {
		return typeIds;
	}
	public void setTypeIds(List<Integer> typeIds) {
		this.typeIds = typeIds;
	}
	public List<Integer> getGenderIds() {
		return genderIds;
	}
	public void setGenderIds(List<Integer> genderIds) {
		this.genderIds = genderIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Gendero> getGenderoIds() {
		return genderoIds;
	}

	public void setGenderoIds(List<Gendero> genderoIds) {
		this.genderoIds = genderoIds;
	}

	

	
	
	
	
	
}
