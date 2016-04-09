package com.ecomlogix.ecom.core.repository.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.ecomlogix.ecom.core.domain.BaseEntity;
import com.ecomlogix.ecom.core.repository.GenericBaseRepository;

public abstract class GenericJpaRepository<ID_T extends Serializable, T extends BaseEntity<ID_T>>
		extends GenericBaseRepository<ID_T, T> {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Iterable<T> getAll() {
		CriteriaQuery<T> criteriaQuery = getCriteriaBuilder().createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public T get(ID_T id) {
		return entityManager.find(entityClass, id);
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return this.entityManager.getCriteriaBuilder();
	}
}
