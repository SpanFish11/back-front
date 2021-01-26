package com.spanfish.backend.rest;

import static org.springframework.http.ResponseEntity.ok;

import com.spanfish.backend.mapper.FilmMapper;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.model.responce.FilmResponse;
import com.spanfish.backend.service.FilmService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/films")
public class FilmController {

  private final FilmService filmService;
  private final FilmMapper filmMapper;

  @GetMapping
  public ResponseEntity<List<FilmResponse>> findFilms(final Filter filter) {
    final var films = filmService.findFilms(filter);
    return ok(filmMapper.toList(films));
  }
}
