package com.ecomlogix.ecom.core.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.ecomlogix.ecom.core.domain.BaseEntity;

public abstract class GenericBaseRepository<ID_T extends Serializable, T extends BaseEntity<ID_T>>
		implements GenericRepository<ID_T, T> {

	protected final Class<ID_T> idClass;
	protected final Class<T> entityClass;

	public GenericBaseRepository(Class<ID_T> idClass, Class<T> entityClass) {
		this.idClass = idClass;
		this.entityClass = entityClass;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericBaseRepository() {
		Type genericSuperclass = this.getClass().getGenericSuperclass();

		while (!(genericSuperclass instanceof ParameterizedType)) {
			if (!(genericSuperclass instanceof Class))
				throw new IllegalStateException(
						"Unable to determine type arguments because generic superclass neither parameterized type nor class.");
			if (genericSuperclass == GenericRepository.class)
				throw new IllegalStateException(
						"Unable to determine type arguments because no parameterized generic superclass found.");
			genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
		}
		ParameterizedType type = (ParameterizedType) genericSuperclass;
		Type[] arguments = type.getActualTypeArguments();
		this.idClass = (Class<ID_T>) arguments[0];
		this.entityClass = (Class<T>) arguments[1];
	}
}
