package com.spanfish.backend.specification.impl;

import static java.util.Objects.isNull;
import static org.springframework.data.jpa.domain.Specification.where;

import com.spanfish.backend.model.entity.Director_;
import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.entity.Film_;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.specification.BaseSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FilmSpecification implements BaseSpecification<Film, Filter> {

  private static final String YEAR = "YEAR";

  @Override
  public Specification<Film> getFilter(final Filter request) {
    return (root, query, cb) -> where(directorLastNameLike(request.getDir()))
        .and(greaterThanOrEqualTo(request.getFrom()))
        .and(lessThanOrEqualTo(request.getUntil()))
        .toPredicate(root, query, cb);
  }

  private Specification<Film> directorLastNameLike(final String lastName) {
    return (root, query, cb) -> isNull(lastName) ? cb.isTrue(cb.literal(true)) : cb.like(
        cb.lower(root.get(Film_.DIRECTOR).get(Director_.LAST_NAME)),
        "%" + lastName.toLowerCase() + "%");
  }

  private Specification<Film> greaterThanOrEqualTo(final Integer from) {
    return (root, query, cb) -> isNull(from) ? cb.isTrue(cb.literal(true))
        : cb.greaterThanOrEqualTo(
            cb.function(YEAR, Integer.class, root.get(Film_.RELEASE_DATE)), from);
  }

  private Specification<Film> lessThanOrEqualTo(final Integer until) {
    return (root, query, cb) -> isNull(until) ? cb.isTrue(cb.literal(true)) :
        cb.lessThanOrEqualTo(
            cb.function(YEAR, Integer.class, root.get(Film_.RELEASE_DATE)), until);
  }
}
