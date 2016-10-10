package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Type;
import ua.form.TypeFilter;

public class TypeFilterAdapter implements Specification<Type>{
	private String search = "";

	
	public TypeFilterAdapter(TypeFilter form) {
		if (form.getSearch()!=null) {
			search=form.getSearch();
		}
		
	}

	@Override
	public Predicate toPredicate(Root<Type> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase()+"%");
	}

}
