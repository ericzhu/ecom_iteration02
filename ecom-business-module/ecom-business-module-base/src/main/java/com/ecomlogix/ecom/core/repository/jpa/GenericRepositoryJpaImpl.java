package com.ecomlogix.ecom.core.repository.jpa;

import java.io.Serializable;

import com.ecomlogix.ecom.core.domain.BaseEntity;
import com.ecomlogix.ecom.core.repository.GenericRepository;

public class GenericRepositoryJpaImpl<ID_T extends Serializable, T extends BaseEntity<ID_T>>
		implements GenericRepository<ID_T, T> {

	protected final Class<ID_T> idClass;
	protected final Class<T> entityClass;

	public GenericRepositoryJpaImpl(Class<ID_T> idClass, Class<T> entityClass) {
		this.idClass = idClass;
		this.entityClass = entityClass;
	}

	@Override
	public Iterable<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(ID_T id) {
		// TODO Auto-generated method stub
		return null;
	}

}
