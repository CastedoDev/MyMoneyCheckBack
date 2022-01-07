package com.castedodev.mymoneycheckback.operation.adapters.out.persistence;

import com.castedodev.mymoneycheckback.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OperationSpecification implements Specification<OperationEntity> {

    private SearchCriteria criteria;

    @Override
    public Specification<OperationEntity> and(Specification<OperationEntity> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<OperationEntity> or(Specification<OperationEntity> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<OperationEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}
