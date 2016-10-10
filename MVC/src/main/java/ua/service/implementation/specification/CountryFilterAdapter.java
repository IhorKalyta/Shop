package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Country;
import ua.form.CountryFilter;

public class CountryFilterAdapter implements Specification<Country> {

	private String search = "";

	public CountryFilterAdapter(CountryFilter form) {

		if (form.getSearch() != null) {
			search = form.getSearch();
		}
	}

	@Override
	public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase() + "%");

	}

}
