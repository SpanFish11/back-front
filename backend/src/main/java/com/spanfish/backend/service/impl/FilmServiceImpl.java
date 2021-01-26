package com.spanfish.backend.service.impl;

import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.repository.FilmRepository;
import com.spanfish.backend.service.FilmService;
import com.spanfish.backend.specification.impl.FilmSpecification;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

  private final FilmRepository filmRepository;
  private final FilmSpecification filmSpecification;

  @Override
  public List<Film> findFilms(final Filter filter) {
    return filmRepository.findAll(filmSpecification.getFilter(filter));
  }
}
