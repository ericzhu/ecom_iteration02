package com.ecomlogix.ecom.core.repository;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import com.ecomlogix.ecom.core.domain.BaseEntity;

@Validated
public interface GenericRepository<ID_T extends Serializable, T extends BaseEntity<ID_T>> {
	
	@NotNull
	public Iterable<T> getAll();

	public T get(@NotNull ID_T id);
}
