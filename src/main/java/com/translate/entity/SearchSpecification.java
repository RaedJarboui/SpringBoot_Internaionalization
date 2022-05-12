package com.translate.entity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchSpecification implements Specification<Languages> {

	private SearchCriteria criteria;

	@Override
	public Predicate toPredicate(Root<Languages> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		switch (criteria.getOperation()) {
		case EQUALITY:
			return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
		case NEGATION:
			return criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue());
		case LESS_THAN:
			return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case GREATER_THAN:
			return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case STARTS_WITH:
			return criteriaBuilder.like(root.<String>get(criteria.getKey()), criteria.getValue() + "%");
		default:
			return null;
		}
	}

}
