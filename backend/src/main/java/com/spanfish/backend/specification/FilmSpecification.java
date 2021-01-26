package com.spanfish.backend.specification;

import com.spanfish.backend.model.entity.Film;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class FilmSpecification {

  private static final String YEAR = "YEAR";

  public static Specification<Film> directorLastNameLike(String lastName) {
    return (root, query, cb) -> {
      if (Objects.isNull(lastName)) {
        return cb.isTrue(cb.literal(true));
      }
      return cb.like(
          cb.lower(root.get(Film_.DIRECTOR).get(Director_.LAST_NAME)),
          "%" + lastName.toLowerCase() + "%");
    };
  }

  public static Specification<Film> greaterThanOrEqualTo(Integer from) {
    return (root, query, cb) -> {
      if (Objects.isNull(from)) {
        return cb.isTrue(cb.literal(true));
      }
      return cb.greaterThanOrEqualTo(
          cb.function(YEAR, Integer.class, root.get(Film_.RELEASE_DATE)), from);
    };
  }

  public static Specification<Film> lessThanOrEqualTo(Integer until) {
    return (root, query, cb) -> {
      if (Objects.isNull(until)) {
        return cb.isTrue(cb.literal(true));
      }
      return cb.lessThanOrEqualTo(
          cb.function(YEAR, Integer.class, root.get(Film_.RELEASE_DATE)), until);
    };
  }
}
