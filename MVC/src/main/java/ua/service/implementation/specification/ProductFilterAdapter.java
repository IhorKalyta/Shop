package ua.service.implementation.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import ua.entity.Product;
import ua.form.ProductFilterForm;

public class ProductFilterAdapter implements Specification<Product> {

	private final ProductFilterForm form;
	private String search = "";

	private final List<Specification<Product>> filters = new ArrayList<>();

	public ProductFilterAdapter(ProductFilterForm form) {
		if (form != null) {
			this.form = form;
		} else {
			this.form = new ProductFilterForm();
		}
		if (form.getSearch() != null) {
			search = form.getSearch();
		}
	}

	private void findByPrice() {
		if (form.getMinInt() != 0 && form.getMaxInt() != 0) {
			filters.add((root, query, cb) -> {
				Expression<Integer> exp = root.get("price");
				return cb.between(exp, form.getMinInt(), form.getMaxInt());
			});
		} else if (form.getMinInt() != 0) {
			filters.add((root, query, cb) -> {
				Expression<Integer> exp = root.get("price");
				return cb.ge(exp, form.getMinInt());
			});
		} else if (form.getMaxInt() != 0) {
			filters.add((root, query, cb) -> {
				Expression<Integer> exp = root.get("price");
				return cb.le(exp, form.getMaxInt());
			});
		}
	}

	private void findByName() {

		filters.add((root, query, cb) -> {
			Expression<String> exp = root.get("name");
			return cb.like(cb.upper(exp), search.toUpperCase() + "%");
		});

	}

	private void findByCategory() {
		if (!form.getCategoryIds().isEmpty()) {
			filters.add((root, query, cb) -> root.get("category").in(
					form.getCategoryIds()));
		}
	}

	private void findByColor() {
		if (!form.getColorIds().isEmpty()) {
			filters.add((root, query, cb) -> root.get("color").in(
					form.getColorIds()));
		}
	}

	private void findByCountry() {
		if (!form.getCountryIds().isEmpty()) {
			filters.add((root, query, cb) -> root.get("country").in(
					form.getCountryIds()));
		}
	}

	private void findByGender() {
		if (!form.getGenderIds().isEmpty()) {
			filters.add((root, query, cb) -> root.get("gender").in(
					form.getGenderIds()));
		}
	}

	private void findByType() {
		if (!form.getTypeIds().isEmpty()) {
			filters.add((root, query, cb) -> root.get("type").in(
					form.getTypeIds()));
		}
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			root.fetch("country", JoinType.LEFT);
			root.fetch("color", JoinType.LEFT);
			root.fetch("category", JoinType.LEFT);
			root.fetch("color", JoinType.LEFT);
			root.fetch("type", JoinType.LEFT);
			root.fetch("gender", JoinType.LEFT);

			query.distinct(true);
		}

		findByName();
		findByPrice();
		findByCategory();
		findByColor();
		findByCountry();
		findByGender();
		findByType();

		if (!filters.isEmpty()) {
			Specifications<Product> spec = Specifications.where(filters.get(0));
			for (Specification<Product> s : filters.subList(1, filters.size())) {
				spec = spec.and(s);
			}

			return spec.toPredicate(root, query, cb);
		}

		return null;
	}

}
