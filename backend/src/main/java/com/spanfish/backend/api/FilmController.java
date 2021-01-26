package com.spanfish.backend.api;

import com.spanfish.backend.mapper.FilmMapper;
import com.spanfish.backend.model.entity.Film;
import com.spanfish.backend.model.request.Filter;
import com.spanfish.backend.model.responce.FilmResponse;
import com.spanfish.backend.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/films")
public class FilmController {

  private final FilmService filmService;
  private final FilmMapper filmMapper;

  @GetMapping
  public ResponseEntity<List<FilmResponse>> findFilms(Filter filter) {
    List<Film> films = filmService.findFilms(filter);
    return new ResponseEntity<>(filmMapper.toList(films), HttpStatus.OK);
  }
}
