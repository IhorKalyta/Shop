package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Color;
import ua.form.ColorFilter;

public class ColorFilterAdapter implements Specification<Color>{
	
	private String search = "";
	
	public ColorFilterAdapter(ColorFilter form) {
		if (form.getSearch()!=null) {
			search=form.getSearch();
		}
		
	}

	@Override
	public Predicate toPredicate(Root<Color> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase()+"%");
	}

}
