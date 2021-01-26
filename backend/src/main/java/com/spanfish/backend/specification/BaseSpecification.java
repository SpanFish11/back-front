package com.spanfish.backend.specification;

import org.springframework.data.jpa.domain.Specification;

public interface BaseSpecification<T, U> {

  Specification<T> getFilter(U request);
}
