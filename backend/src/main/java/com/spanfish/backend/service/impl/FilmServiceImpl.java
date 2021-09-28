package com.spanfish.backend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.spanfish.backend.mapper.FilmMapper;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.model.responce.FilmResponse;
import com.spanfish.backend.repository.FilmRepository;
import com.spanfish.backend.service.FilmService;
import com.spanfish.backend.specification.impl.FilmSpecification;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

  private final FilmRepository filmRepository;
  private final FilmSpecification filmSpecification;
  private final FilmMapper filmMapper;

  @Override
  public List<FilmResponse> findFilms(final Filter filter) {
    return filmRepository.findAll(filmSpecification.getFilter(filter)).stream()
        .map(filmMapper::toDto)
        .toList();
  }
}
