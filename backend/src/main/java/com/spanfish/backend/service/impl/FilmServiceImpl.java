package com.spanfish.backend.service.impl;

import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.repository.FilmRepository;
import com.spanfish.backend.service.FilmService;
import com.spanfish.backend.specification.FilmSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

  private final FilmRepository filmRepository;

  @Override
  public List<Film> findFilms(Filter filter) {
    Specification<Film> specification =
        Specification.where(FilmSpecification.directorLastNameLike(filter.getDir()))
            .and(FilmSpecification.greaterThanOrEqualTo(filter.getFrom()))
            .and(FilmSpecification.lessThanOrEqualTo(filter.getUntil()));
    return filmRepository.findAll(specification);
  }
}
